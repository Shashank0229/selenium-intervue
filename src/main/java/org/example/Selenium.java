import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Selenium {
    public static void main(String[] args) {
        String[][] credentials = {
                {"neha@intervue.io", "Neha@567intervue"}
        };

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/tmp/selenium-profile");
        options.addArguments("--guest");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-features=TranslateUI");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-features=OmniboxLocalZeroSuggest,OmniboxOnDeviceHeadSuggestions");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.intervue.io/");
        System.out.println("Opened Intervue homepage");

        WebElement accessAccountPage = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".loginBtn"))
        );
        accessAccountPage.click();
        System.out.println("Clicked access account");

        String originalTab = driver.getWindowHandle();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                System.out.println("Switched to login tab");
                break;
            }
        }

        WebElement loginLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div.AccessAccount-Card.Companies a.AccessAccount-ColoredButton[href='/login']")
                )
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", loginLink);
        loginLink.click();
        System.out.println("Clicked login link");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));

        emailField.sendKeys(credentials[0][0]);
        passwordField.sendKeys(credentials[0][1]);
        System.out.println("Entered credentials");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.LoginDarkButton-sc-1ertvag-0.ant-btn-primary")
        ));
        loginButton.click();
        System.out.println("Clicked login button");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.HeaderSearch__SearchLensIconWrap-sc-1140h69-2.hVEOxf")
        ));
        searchIcon.click();
        System.out.println("Clicked search icon");

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".ant-modal-wrap")
        ));

        WebElement inputWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".SearchBox__InputWrapper-ctnsh0-1.eaVgZO")
        ));
        WebElement input = inputWrapper.findElement(By.tagName("input"));
        input.sendKeys("hello");
        System.out.println("Entered search query");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement suggestionContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".SearchThrough__PlaceholderText-sc-8f4vh4-0.fEvpzS")
        ));
        WebElement firstSpan = suggestionContainer.findElement(By.tagName("span"));
        firstSpan.click();
        System.out.println("Clicked search suggestion");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.Dropdown__Wrapper-ejd68n-0.kjKPLV")
        ));
        dropdown.click();
        System.out.println("Opened dropdown");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/logout']")
        ));
        logout.click();
        System.out.println("Clicked logout");
        driver.quit();
    }
}
