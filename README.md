# Spring AOP Demo

This repository demonstrates the key concepts of Aspect-Oriented Programming (AOP) using Spring Boot. It includes practical examples of different types of advice (`@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`) to handle cross-cutting concerns such as logging.

---

## **Features**

- Modular handling of logging with Spring AOP.
- Demonstrates various types of AOP advice.
- RESTful API endpoints for testing AOP functionality.
- Built with Spring Boot for easy setup and execution.

---

## **Project Structure**

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.example.spring_aop_demo
│   │   │   │   ├── SpringAopDemoApplication.java  # Main application class
│   │   │   │   ├── DemoController.java            # REST Controller
│   │   │   │   └── LoggingAspect.java             # Aspect class
│   │   └── resources
│   │       └── application.properties             # Application properties
├── pom.xml                                         # Maven dependencies
└── README.md                                       # Project documentation
```

---

## **Endpoints**

### **1. `/greet`**
- **Description**: Returns a greeting message.
- **Response**: `Hello, World!`
- **Logs**:
  ```
  [Before Advice] Method execution started
  [Around Advice] Before method execution
  [After Returning Advice] Returned value: Hello, World!
  [Around Advice] After method execution
  [After Advice] Method execution completed
  ```

### **2. `/error`**
- **Description**: Simulates an error.
- **Response**: Throws a runtime exception.
- **Logs**:
  ```
  [Before Advice] Method execution started
  [Around Advice] Before method execution
  [After Throwing Advice] Exception thrown: An error occurred!
  [Around Advice] Exception: An error occurred!
  [After Advice] Method execution completed
  ```

---

## **Getting Started**

### **Prerequisites**
- Java 17+
- Maven 3.6+

### **Installation**

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/spring-aop-demo.git
   ```

2. Navigate to the project directory:
   ```bash
   cd spring-aop-demo
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## **Key Classes**

### **1. `SpringAopDemoApplication`**
The entry point of the application. Annotated with `@EnableAspectJAutoProxy` to enable AOP.

### **2. `DemoController`**
A simple REST controller with two endpoints:
- `/greet`: Returns a greeting message.
- `/error`: Simulates an error.

### **3. `LoggingAspect`**
The aspect class containing advice for logging method execution details.

---

## **Example Logs**

### **Successful Request to `/greet`**
```
[Before Advice] Method execution started
[Around Advice] Before method execution
[After Returning Advice] Returned value: Hello, World!
[Around Advice] After method execution
[After Advice] Method execution completed
```

### **Error Request to `/error`**
```
[Before Advice] Method execution started
[Around Advice] Before method execution
[After Throwing Advice] Exception thrown: An error occurred!
[Around Advice] Exception: An error occurred!
[After Advice] Method execution completed
```

---


---

## **Contributing**

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

Happy coding!
