# EcomBackend + SpringBoot

A backend REST API for an e-commerce application built using **Java, Spring Boot, Spring Data JPA, and H2 Database**. The application provides product management functionality, including CRUD operations, product image uploads, and keyword-based product search.

## 🚀 Features

- **Product Management:** Create, retrieve, update, and delete products.
- **Product Image Upload:** Upload product images using multipart form data.
- **Product Search:** Search for products using keywords.
- **RESTful APIs:** Implemented HTTP methods such as GET, POST, PUT, and DELETE.
- **Layered Architecture:** Organized into Controller, Service, and Repository layers.
- **Database Integration:** Uses Spring Data JPA with an H2 in-memory database.
- **API Testing:** Tested API endpoints using Postman.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Application development |
| Spring MVC | REST API and request handling |
| Spring Data JPA | Database operations |
| Hibernate | ORM implementation |
| H2 Database | Data storage |
| Maven | Dependency management and build |
| Postman | API testing |
| Git & GitHub | Version control |

## 🏗️ Project Architecture

The application follows a layered architecture to separate responsibilities.

```text
EcomBackend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/EcomBackend/
│       │       ├── controller/
│       │       │   └── ProductController.java
│       │       ├── service/
│       │       ├── repository/
│       │       ├── model/
│       │       └── EcomBackendApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

*Note: The structure above is illustrative. Adjust the package and file names to match your actual project.*

## 📡 API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/products` | Retrieve all products |
| GET | `/api/product/{id}` | Retrieve a product by ID |
| POST | `/api/product` | Create a product with an image |
| PUT | `/api/product/{id}` | Update a product and its image |
| DELETE | `/api/product/{id}` | Delete a product |
| GET | `/api/products/search?keyword={keyword}` | Search products by keyword |

### Example: Search Products

```http
GET http://localhost:8080/api/products/search?keyword=phone
```

### Creating or Updating a Product

The create and update endpoints accept `multipart/form-data` with two parts:

- `product`: Product details in JSON format.
- `imageFile`: Product image file.

The exact JSON fields depend on the `Product` model defined in the project.

## ⚙️ Getting Started

### Prerequisites

- Java (compatible with your project configuration)
- Maven
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/EcomBackend.git
cd EcomBackend
```

Replace `YOUR_USERNAME` with your GitHub username.

### 2. Run the Application

Using Maven Wrapper, if included:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Alternatively, if Maven is installed:

```bash
mvn spring-boot:run
```

### 3. Test the APIs

Open Postman and send requests to the endpoints listed above.

**Note:** The H2 database is configured as an in-memory database, so its data is generally lost when the application restarts. Check `application.properties` for the actual database and server configuration.

## 🧪 Testing

The API can be tested using Postman by verifying:

- Retrieving all products and individual products.
- Creating products with image uploads.
- Updating existing products.
- Deleting products.
- Searching products by keyword.

## 🔮 Future Improvements
