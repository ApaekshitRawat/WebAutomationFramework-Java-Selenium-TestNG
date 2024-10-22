
# WebAutomationFramework-Java-Selenium-TestNG

o(*￣︶￣*)o

## Getting Started

These instructions will help you set up and run the tests in this automation framework.

### Prerequisites

- Java
- Maven
- Selenium WebDriver
- TestNG

### Installation

To install the framework, navigate to the project directory and run one of the following commands:

```bash
mvn clean install
or
mvn install
```
Running All Tests
To run all tests ending with "test":
```bash
mvn test
```
Running Tests by Profile
To run tests according to the profiles set in pom.xml:
```bash
mvn test -PRegression
mvn test -PPurchase
mvn test -PErrorValidation
```
To Run Tests in different browsers (default is chrome)
```bash
mvn test -PRegression -Dbrowser=Firefox
mvn test -PRegression -Dbrowser=Edge
mvn test -PRegression -Dbrowser=Chrome
mvn test -PRegression -Dbrowser=ChromeHeadless
```
Running Tests in Eclipse IDE
If you prefer not to use the terminal, you can simply run the TestNG XML files located in the TestSuites directory of your Eclipse project.
Built With

Java - The programming language used
Selenium WebDriver - The web framework used for automation
TestNG - Testing framework
Maven - Dependency Management

Authors

Apaekshit Rawat



