# DemoBlaze Automation Testing Project

## Overview
This project is an end-to-end automation testing suite for the DemoBlaze e-commerce web application.  
It is built using **Selenium WebDriver**, **TestNG**, and follows the **Page Object Model (POM)** design pattern.  
The project supports **data-driven testing**, generates **Allure reports**, and integrates **CI/CD** using **GitHub Actions**.

---

## Features / Minimum Requirements Implemented

1. **Page Object Model (POM)** - organizes pages and actions for maintainability.
2. **Test Execution & Grouping with TestNG** - tests are grouped by feature and priority.
3. **Data-driven Approach** - test inputs from **CSV/JSON/Excel** via TestNG `DataProvider`.
4. **TestNG Listeners** - logs test execution and takes screenshots on failure.
5. **Allure Reports** - detailed reporting of test execution.
6. **Screenshots for Failed Tests** - automatically attached in Allure reports.
7. **Logging** - configured with **Log4j2** for debug and info logs.
8. **TestNG Suites** - `testng.xml` provided for full or grouped test execution.
9. **GitHub Repository** - project hosted publicly with frequent descriptive commits.
10. **Maven** - used for building and running tests.
11. **GitHub Actions** - CI pipeline executes Regression Suite and publishes Allure reports.

---

## Technologies Used

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Allure Framework
- Log4j2
- Git & GitHub
- GitHub Actions (CI/CD)
- Data files: JSON/CSV/Excel

---

## Project Structure
src/
├─ main/java/pages # Page classes (POM)
├─ main/java/utils # Utilities (logging, screenshots, data readers)
├─ test/java/tests # Test classes (TestNG)
├─ test/resources/data # Test data (CSV/JSON/Excel)
└─ test/resources/config # Configuration files (properties, logs)
pom.xml # Maven configuration
testng.xml # TestNG suite configuration
screenshots/ # Screenshots for failed tests



---

## Test Cases Implemented

| Feature | Test Case Description |
|---------|----------------------|
| Register | Valid user registers → success confirmation |
| Register Validation | Invalid/duplicate user → proper error message |
| Login | Valid user login → username displayed |
| Login Negative | Wrong credentials → error message displayed |
| Add to Cart | Product added successfully |
| Checkout Flow | Complete checkout or simulate step |

---

## How to Run Tests

### 1. Clone the repository
```bash
git clone https://github.com/mohamed12hamdy/DemoBlaze.git
cd DemoBlaze

mvn clean test

# Serve report locally
allure serve ./allure-results

# Or generate and open


### Video Demonstration
[Watch Test Run Video](videos/DemoBlaze-Demo.mp4)

## Logging

All logs are stored in logs/Log.log.
Configured via Log4j2 to provide detailed info and error logging.


## Github Actions CI/CD
Regression tests are automatically triggered on:

Push to the main branch

Pull requests targeting main

Only the Regression Suite is executed in the workflow.

Allure reports for the Regression Suite are generated and can be published as an artifact.

