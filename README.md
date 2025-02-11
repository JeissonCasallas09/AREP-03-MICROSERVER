# AREP-03 MICROSERVER

For this project, a microserver has been developed using technologies such as Java, JavaScript, CSS, and HTML. Its uniqueness lies in leveraging Java features like reflection and annotations to handle dynamic REST requests in a non-concurrent manner. This is achieved through the definition of controllers, endpoints, and the use of parameters when specifying routes within the web application.

![](/images/1.png)
![](/images/2.png)
![](/images/3.png)
![](/images/4.png)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools to run the project:
1. Java

   Try using the following command
    ```
    java -version
    ```
    You should see something like this:

    ![](/images/5.png)

2. Maven

   We need maven too, so use the following command.

    ```
    mvn -version
    ```
    You should see something like this:
    
    ![](/images/6.png)

3. Git

   To finish, we must have git. You can check it with this command.
    ```
    git --version
    ```
    It should appear something like this:
    
    ![](/images/7.png)

### Installing

1. First, we need to open a terminal and put the following command to clone the project:

    ```
    git clone https://github.com/JeissonCasallas09/AREP-03-MICROSERVER
    ```
2. Open the folder with the project in a new terminal and build it with the following command:
    ```
    mvn package
    ```
    This message will tell you that it was successfull:

     ![](/images/8.png)

3. Now just run the project using:
    ```
    mvn exec:java
    ```
    The project is now running:

    ![](/images/9.png)
    
4. Enter from your browser to the local server with port 35000

 ![](/images/10.png)


## Architecture
 ![](/images/12.png)

### Overview
Project Architecture
This project follows a simple microserver-based architecture with three main components:

* ### Static Files

   * Contains essential frontend assets, including:

   * Styles: CSS files for styling the interface.

    * Script: JavaScript files for dynamic behavior.

   * Index: The main HTML file that serves as the entry point of the application.
   These files are served by the server to the client.

* ### Server

   * Implements a MicroServer responsible for handling requests and serving static files.
   * Acts as an intermediary between the client and backend logic.

* ### Controller

   * The GreetingController manages request handling and responses.
   * It processes user requests and provides appropriate responses.

* ### Workflow

   1. The client accesses the Static Files (HTML, CSS, JavaScript) through the MicroServer.
   2. The MicroServer communicates with the GreetingController to handle dynamic requests.
   3. The GreetingController processes incoming requests and returns the necessary data.
   
This architecture ensures a clear separation of concerns, allowing for easy maintenance and scalability.

![](/images/13.png)

* ### Interfaces
   1. RequestParam:
      
      * Used to handle parameters in HTTP requests.
      * Methods:
         1. value() : String → Returns the parameter's value.
         2. defaultValue() : String → Defines a default value.

   2. GetMapping:
      * Maps methods to HTTP GET routes.
      * Method:
         1. value() : String → Returns the assigned route.

   3. RestController:
      * Indicates that a class is a REST controller, used for Annotations.

* ### GreetingController Class
   This class acts as a controller within the web server, handling different routes and performing string operations.

   Main Methods:

   1. greeting(name: String) : String

      * Returns a personalized greeting with the received name.
      * Example: GET /app/greeting?name=John → "Hello, John!"
   
   2. pi() : String

      * return a predefined value, in this case the value of PI.
   
   3. index() : String

      *  Returns a  welcome message.
   
   4. countChars(word: String) : String

      * Returns the number of characters in the given word.
      * Example: GET /app/countChars?word=hello → "5"
   
   5. concat(a: String, b: String) : String

      * Concatenates two strings and returns the result.
      * Example: GET /app/concat?a=Hello&b=World → "HelloWorld"
   
   6. max(a: String, b: String, c: String) : String

      * Returns the maximum value among three strings (likely compared alphabetically or numerically).
      * Example: GET /app/max?a=3&b=5&c=4 → "5"

*  ### MicroServer Class
This is the core class of the server, managing HTTP requests and responses.

   #### Attributes:
   *  PORT : int = 8080 → Defines the port where the server listens.

   * BASE_PATH : String = "/app" → Base path for requests.

   * STATIC_FOLDER : String = "src/main/java/edu/eci/arep/webserver/static/"
   → Directory where static files (HTML, CSS, JS) are stored.
   
   * routes : Map<String, Method> → Maps routes to their corresponding methods.

   #### Main Methods:
   
   1. main(args: String[]) : void

      * Main entry point to start the server.
   
   2. startServer() : void

      * Starts the server on port 8080 and waits for requests.
   
   3. registerRoutes() : void

      * Registers the available routes in the controller.
   
   4. invokeControllerMethod(path: String, queryString: String) : String

      *  Calls the controller method associated with the requested route.
   
   5. extractParameters(method: Method, queryString: String) : Object[]

      * Extracts parameters from a request and assigns them to the controller methods.
   
   6. parseQuery(query: String) : Map<String,String>

      * Parses the query string (?param1=value1&param2=value2) into a key-value map.
   
   7. sendResponse(out: OutputStream, status: String, contentType: String, body: String) : void

      * Sends an HTTP response to the client with the generated content.
   
   8. serveStaticFile(out: OutputStream, filePath: String) : void

      * Serves static files like HTML, CSS, or images.
   
   9. getContentType(filePath: String) : String

      * Determines the content type of a requested file (e.g., text/html, application/json, etc.).
   
   10. getRoutes() : Map<String,Method>

   * Determines the content type of a requested file (e.g., text/html, application/json, etc.).


## Running the tests

The project includes unit tests to validate the functionality of the MicroServer, ensuring correct behavior when handling dinamic files, REST endpoints, and content types. Below is an explanation of each test:

### GreetingControllerTest

1. testGreetingDefault()
   
   **Description:**
   Verifies that the greeting method returns the default greeting when the name "World" is provided.

   **Test Case:**
   ```
   Input: "World"
   Expected Output: "Hola World"
   ```
2. testGreetingWithName()
   
   **Description:**
   Checks that the greeting method returns a personalized greeting when a specific name is provided.
   
   **Test Case:**
   ```
   Input: "Juan"
   Expected Output: "Hola Juan"
   ```
3. testPi()
   
   **Description:**
   Validates that the pi method returns the value of π as a string.

   **Test Case:**
   ```
   Input: "" (no parameters)
   Expected Output: 3.141592653589793
   ```
4. testIndex()
   
   **Description:**
   Verifies that the index method returns the expected welcome message.
   
   **Test Case:**
   ```
   Input: N/A
   Expected Output: "Greetings from Spring Boot!"
   ```
5. testCountChars()
   
   **Description:**
   Tests that the countChars method correctly counts the characters in a word and returns the appropriate message.
   
   **Test Case:**
   ```
   Input: "Hola"
   Expected Output: "La palabra 'Hola' tiene 4 caracteres."
   ```
6. testConcat()

   **Description:**
   Verifies that the concat method correctly concatenates two words and returns the formatted result.

   **Test Case:**
   ```
   Input: "Hola", "Mundo"
   Expected Output: "Resultado: Hola Mundo"
   ```
7. testMax()

   **Description:**
   Checks that the max method returns the highest number among three positive values.

   **Test Case:**
   ```
   Input: "3", "8", "5"
   Expected Output: "El número mayor es: 8"
   ```

8. testMaxWithNegativeNumbers()
   
   **Description:**
   Validates that the max method works correctly with negative numbers and returns the largest one.
   
   **Test Case:**
   ```
   Input: "-1", "-3", "-5"
   Expected Output: "El número mayor es: -1"
   ```

### MicroServerTest

1. testRoutesAreRegistered()

   **Description:**
   Verifies that the server correctly registers the available routes upon initialization.

   **Test Case:**
      ```
      Expected Behavior:
      The routes map should not be null.
      It should contain at least one registered route.
      The /app/greeting route should be present.
      ```
2. testInvokeControllerMethod()

   **Description:**
   Tests that the server correctly invokes the controller method associated with a registered route.

   **Test Case:**
   ```
   Input: Route "/app/greeting" with query "name=Juan"

   Expected Output: "Hola Juan"
   ```

3. testInvokeNonExistentRoute()

   **Description:**
   Validates that invoking a non-existent route returns an appropriate error message.

   **Test Case:**
   ```
   Input: Route "/app/notfound" with an empty query

   Expected Output: {"error": "Ruta no encontrada"}
   ```
4. testParseQueryParameters()
   
   **Description:**
   Checks that the query string parsing method correctly extracts key-value parameters.
   
   **Test Case:**
   ```
   Input: "name=Juan&age=25"
   Expected Output:
   "name" → "Juan"
   "age" → "25"
   ```
5. testSendResponse()

   **Description:**
   Tests that the server correctly formats and sends an HTTP response.

   **Test Case:**
   ```
   Input:
   Status: "200 OK"
   Content Type: "text/plain"
   Body: "Hello Test"

   Expected Output: The generated response should contain:
   "HTTP/1.1 200 OK"
   "Content-Type: text/plain"
   "Hello Test"
   ```


![](/images/11.png)

These tests validate the core functionality of the MicroServer and the GreetingController, ensuring it properly serves dinamic files, REST responses,annotations and handles content type detection effectively. 🚀



## Conclusions

The MicroServer project is a lightweight web server developed in Java, designed to handle HTTP requests dynamically while serving both static and dynamic content. By leveraging reflection and annotations, the server provides a simple yet extensible framework for building web applications. The following conclusions summarize key aspects of its design, implementation, and potential improvements.


1. Implementation of a Minimalist Web Server ✅

   * A lightweight web server was developed in Java, capable of handling HTTP requests, serving static files, and processing dynamic routes.
   * The server architecture allows extension through controllers annotated with @GetMapping.

2. Dynamic Request Processing ✅

   * A mechanism was implemented to register and execute controller methods dynamically using reflection.
   * Parameter extraction and request handling were added, enabling flexible endpoint development.

3. Static File Handling ✅

   * Support for serving HTML, CSS, JavaScript, images, and other formats from a static folder was included.
   * The Content-Type is determined based on the requested file extension.

4. Unit Testing for Functionality Validation ✅

   * JUnit tests were developed to validate route registration, correct controller method execution, and parameter processing.
   * Proper construction and transmission of HTTP responses were verified.

5. Modularity and Extensibility ✅

   * The annotation-based architecture allows new routes to be added easily without modifying the server logic.
   * The separation between the server, controllers, and static file handling improves code maintainability.

6. Use of Design Patterns ✅

   * The Front Controller pattern was applied, directing all HTTP requests to a single entry point.
   * Reflection was used for dynamic method invocation in controllers, facilitating system extension.


The MicroServer project demonstrates the implementation of a simple yet effective web server, providing fundamental features for handling web requests dynamically. 🚀


## Built With

* [Maven](https://maven.apache.org/) - Dependency Control
* [GIT](https://git-scm.com) - Versioning


## Versioning

versioning made it by [GitHub](http://git-scm.com).

## Authors

* **Jeisson Steban Casallas Rozo** - [JeissonCasallas09](https://github.com/JeissonCasallas09)

Date: 10/02/2025
## License

This project is licensed by ECI.

