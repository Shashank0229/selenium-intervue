# Selenium Intervue Automation

This project automates the login, search, and logout workflow on [Intervue.io](https://www.intervue.io) using Selenium WebDriver in Java.

## 🧪 Features

- Launches Chrome with custom options to simulate user behavior
- Logs in with valid credentials
- Performs a search action
- Logs out from the application
- Logs key steps using `System.out.println()`

---

## ⚙️ Requirements

Ensure the following tools are installed on your machine:

- **Java 17** – Compatible with the latest features and stable modules
- **Maven** – Project uses Maven for dependency management and builds
- **Chrome Browser** – Required for Selenium WebDriver execution
- **IDE** – Recommended: IntelliJ IDEA for easy Maven and Selenium integration

---

## 📂 Project Structure

- `Selenium.java`: Main class that contains the entire test flow (login → search → logout)
- `pom.xml`: Maven configuration file with dependencies for Selenium

---

## 🚀 How to Run

### ▶️ From IDE (Recommended)

1. Open the project in IntelliJ IDEA (or any Java IDE).
2. Open `Selenium.java`.
3. Click **Run** or use the shortcut `Shift + F10`.

### 💻 From Terminal

```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.Selenium"
