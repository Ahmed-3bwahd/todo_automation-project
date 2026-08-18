# Todo Automation Project

This project contains automated UI and API tests for the Todo Web Application.  
The framework validates essential user flows such as login, adding todos, deleting todos, and uses API calls to speed up test setup and improve test reliability.

---

## Tech Stack

- Java 26
- Selenium WebDriver 4.45.0
- TestNG 7.12.0
- WebDriverManager 6.3.4
- Rest-Assured 6.0.1
- JavaFaker 1.0.2
- Allure TestNG 2.35.4
- AspectJ Weaver 1.9.25.1

---

## Project Structure

src

    ├── main
        └── java
    └── test
        ├── java
            └── com.qacart.todo
                ├── apis
                ├── base
                ├── config
                ├── factory
                ├── objects
                ├── pages
                ├── testcases 
                └── utils
    └── resources


### Folder Responsibilities

- apis → API classes (Register API, Add New Task API)
- base → BaseTest, BasePage
- config → ConfigUtils, EndPoints, properties
- factory → WebDriver initialization
- objects → POJOs (User, Task)
- pages → Page Object Model
- testcases → UI + API test classes
- utils → Waits, cookie converter, helpers

---

## API Testing (Rest-Assured)

This project uses **Rest-Assured** to perform backend operations such as:

### Register API
Creates a new user and returns:
- Cookies
- Access token
- First name
- User ID

**JavaFaker is used to generate random user data** (email, first name, last name, password) for registration requests.  
This ensures every test runs with a fresh, unique user.

### Add New Task API
Adds a new todo item directly via API using:
- OAuth2 token
- JSON body (`Task` object)

### POJO Models
- `User` → request body for registration
- `Task` → request body for creating todos

---

## Cookie Injection (Hybrid UI + API)

The framework supports injecting API cookies into the browser:

injectCookieIntoBrowser(restAssuredCookies);

This allows tests to skip UI login and start directly from an authenticated state.

### Benefits:

- Faster test execution

- More stable tests

- Cleaner setup

--- 

## How to Run Tests

Run the TestNG suite using Maven: **mvn clean test**

Suite file: src/test/resources/testng.xml

### Parallel execution enabled:
- parallel="methods"
- eadCount="3"

---

## Browser Selection

Default browser: **Chrome**

Run with Edge: **mvn clean test -Dbrowser=EDGE**

---

## Configuration

Environment and test data values are stored in:

**src/test/java/com/qacart/todo/config/production.properties**

Loaded through ConfigUtils.

---

## Screenshots

After each test, a screenshot is saved to:

**target/screenshots/**

Screenshots are also attached to Allure reports.

---

## Allure Reporting

Generate and view the report:

- **allure serve target/allure-results**

---

## Application Under Test

URL:  
https://qacart-todo.herokuapp.com/login


