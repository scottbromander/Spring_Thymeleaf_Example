# Spring Boot + Thymeleaf + REST API Project

This is a simple **Spring Boot** project using **Thymeleaf** for server-side rendering and a basic **REST API** to serve data. The client-side JavaScript fetches data from the API and dynamically updates the page.

---

## 🛠️ Setup & Installation

### **1. Prerequisites**
Make sure you have:
- Java **17+** installed ([Download Here](https://adoptopenjdk.net/))
- Gradle installed (or use the **Gradle wrapper** included)
- IntelliJ IDEA Community Edition or any IDE of your choice

### **2. Clone the Repository**
```sh
git clone https://github.com/your-username/spring-boot-thymeleaf.git
cd spring-boot-thymeleaf
```

### **3. Run the Application**

Run the Application
```sh
./gradlew bootRun   # macOS/Linux
gradlew.bat bootRun # Windows
```

### **4. View the Homepage**

Once the app is running, open your browser and visit:
```sh
http://localhost:8080/
```

---

## 🚀 Features
- ✅ **Spring Boot** with Gradle
- ✅ **Thymeleaf** for rendering dynamic HTML templates
- ✅ **REST API** serving JSON data (`/api/data`)
- ✅ **JavaScript (app.js)** to fetch and display data
- ✅ **Modern UI styling** using CSS
- ✅ **Spring Boot DevTools** for live reload (optional)


# 1 . DemoApplication (Entry Point)

📍 File: `DemoApplication.java`

### What It Does
- This is the main entry point of the Spring Boot application.
- Bootstraps the entire app, meaning it initializes everything.
- Uses Spring Magic to automatically scan for controllers, services, and other components.

### Manual Work vs. Spring Boot Automation

✅ Manual Work:
- We explicitly define this class and call `SpringApplication.run(DemoApplication.class, args)`.

⚡ Spring Magic:
- The `@SpringBootApplication` annotation does all of the following:
  - Enables component scanning (@ComponentScan) to auto-detect controllers, services, and repositories.
  - Enables Spring Boot’s auto-configuration (`@EnableAutoConfiguration`).

# 2. `DataController` (REST API)

📍 File: `DataController.java`

### What It Does
- This is a REST API controller that exposes data at `/api/data`.
- Handles HTTP GET requests and returns JSON.

### Manual Work vs. Spring Boot Automation

✅ Manual Work:
- We manually create a class and annotate it with `@RestController` and `@RequestMapping("/api")`.
- We define a `@GetMapping("/data")` method that returns hardcoded JSON data.

⚡ Spring Magic:

- `@RestController`:
  - Auto-registers this class as a web controller.
  - Automatically converts Java objects (like `List<Map<String, String>>`) into JSON.
- `@RequestMapping("/api")`:
  - Automatically maps all routes inside this class under /api.
- `@GetMapping("/data")`:
  - Automatically exposes the method as an HTTP GET endpoint.
  - Auto-serializes the return value (a Java List) into JSON.

# 3. `PageController` (Thymeleaf View Controller)

📍 File: `PageController.java`

### What It Does
- Serves the index.html template at `/`.
- This is a server-side rendered page (Thymeleaf).

### Manual Work vs. Spring Boot Automation

✅ Manual Work:
- We manually create the `PageController` class.
- We annotate it with `@Controller`.
- We define a `@GetMapping("/")` method that returns `"index"`, which matches `index.html` in `templates/`.

⚡ Spring Magic:
- `@Controller`:
  - Registers this class as a web controller that returns views (not JSON).
- `@GetMapping("/")`:
  - Auto-maps the method to handle HTTP GET / requests.
- return `"index";`:
  - Automatically maps "index" to src/main/resources/templates/index.html using Thymeleaf.

#4. How Everything Works Together
###Request Flow
1. User visits `/` (Homepage)
   - `PageController` returns `index.html` from the `templates/` folder.
2. User clicks the "Load Data" button
   - `app.js` makes an AJAX call to `/api/data`.
3. Request to `/api/data`
   - `DataController` receives the request.
   - Returns JSON (`[{ "id": "1", "name": "Alice" }, {...}]`).
4. JavaScript updates UI
   - The response is rendered dynamically in the browser.

# Final Thought
- We focus on "What" happens (business logic), while Spring handles the "How".
- Spring Boot auto-scans, auto-wires, and auto-configures most of the work behind the scenes.
- Understanding what’s manual vs. automatic helps us debug and customize when needed.