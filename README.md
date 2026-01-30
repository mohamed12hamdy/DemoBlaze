

## DemoBlaze - Test automation framework

This project is an end-to-end automation testing suite for the DemoBlaze e-commerce web application.  
It is built using **Selenium WebDriver**, **TestNG**, and follows the **Page Object Model (POM)** design pattern.  
The project supports **data-driven testing**, generates **Allure reports**, and integrates **CI/CD** using **GitHub Actions**
## Tech Stack

This project is built using the following technologies:

- **Language:** Java 21
- **Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build & Dependency Management:** Maven
- **Reporting:** Allure Framework
- **Logging:** Log4j2
- **Version Control:** Git & GitHub
- **CI/CD:** GitHub Actions
- **Test Data:** JSON, CSV, Excel
- **Design Pattern:** Page Object Model (POM)

## Features


1. **Page Object Model (POM)** - Organizes pages and actions for better maintainability.
2. **Test Execution & Grouping with TestNG** - Allows grouping of tests by feature, priority, or suite.
3. **Data-Driven Approach** - Supports test inputs from CSV, JSON, Excel files, or TestNG `DataProvider`.
4. **TestNG Listeners** - Logs test execution and captures screenshots on test failure.
5. **Allure Reports** - Generates detailed reports for each test run.
6. **Screenshots for Failed Tests** - Automatically attached to Allure reports for easier debugging.
7. **Logging Configuration** - Uses Log4j2 or SLF4J for structured logging.
8. **TestNG Suites** - Provides `testng.xml` (or multiple suites) to run tests selectively.
9. **GitHub Repository Hosting** - Project is hosted publicly with frequent, descriptive commits.
10. **Maven Integration** - Uses Maven for build, dependency management, and running tests.
11. **CI/CD via GitHub Actions** - Schedules and executes tests automatically, including Allure report publishing.


## Test Cases Implemented

- **Register:** Valid user registers → success confirmation
- **Register Validation:** Invalid/duplicate user → proper error message
- **Login:** Valid user login → username shown.
- **Login Negative:** Wrong credentials → error message.
- **Add to Cart:** Product added successfully.
- **Checkout Flow:** Complete checkout or simulate steps.
- **Checkout Flow:** Complete checkout without login.

### Demo

See the DemoBlaze Test Automation Framework (TAF) in action:  

[▶ Watch DemoBlaze TAF Demo](https://www.youtube.com/watch?v=E-KONaCa_hA)


## 👨‍💻 Author

**Mohamed Hamdy**   

🔗 [LinkedIn](https://github.com/mohamed12hamdy)  
📧 mohamed2022001m@gmail.com
