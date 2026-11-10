# Inventory Management System

A web-based Inventory Management System developed using **Java Servlets, JSP, JDBC, MySQL, and Apache Tomcat**. The application helps manage products, monitor stock levels, record sales, and maintain inventory efficiently.

## Features

- **Dashboard:** View an overview of inventory activities.
- **Add Products:** Add new products to the inventory.
- **View Products:** Display available products.
- **Search Products:** Search for products using keywords.
- **Low Stock Monitoring:** Identify products with low quantities.
- **Restock Management:** Update product quantities and maintain restock history.
- **Sales Management:** Record and view sales transactions.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Java Servlets | Request handling and business logic |
| JSP | Dynamic frontend |
| HTML, CSS, JavaScript | User interface |
| JDBC | Database connectivity |
| MySQL | Database management |
| Apache Tomcat 10.1 | Web application server |
| VS Code | Development environment |

## Project Structure

```text
InventoryManagementSite/
│
├── src/
│   └── com/inventory/servlet/
│       ├── AddProductServlet.java
│       ├── SalesServlet.java
│       ├── SearchProductServlet.java
│       ├── UpdateProductServlet.java
│       ├── ViewProductsServlet.java
│       └── ViewSalesServlet.java
│
├── WEB-INF/
│   ├── web.xml
│   └── lib/
│       └── mysql-connector-j-9.4.0.jar
│
├── index.jsp
├── dashboard.jsp
├── addProduct.jsp
├── viewProducts.jsp
├── viewSales.jsp
└── README.md
```

*Note: Update the structure if your actual folder names differ.*

## Database Setup

1. Install and start MySQL.
2. Open MySQL Workbench or your preferred MySQL client.
3. Create the project database:

```sql
CREATE DATABASE inventory_management;
USE inventory_management;
```

4. Create the required tables according to the application's database implementation.
5. Update the database connection details in your Java JDBC connection code.

Example JDBC connection:

```java
String url = "jdbc:mysql://localhost:3306/inventory_management";
String username = "root";
String password = "YOUR_PASSWORD";

Connection con = DriverManager.getConnection(
    url, username, password
);
```

Make sure the MySQL JDBC Connector JAR is available in `WEB-INF/lib`.

## Running the Application

### Prerequisites

- JDK installed
- MySQL Server installed and running
- Apache Tomcat 10.1 installed
- MySQL JDBC Connector

### Step 1: Start MySQL

Start your MySQL server and ensure that the project database is available.

### Step 2: Start Apache Tomcat

Navigate to the Tomcat `bin` directory.

For example:

```cmd
cd D:\apache-tomcat-10.1.48\bin
```

Execute:

```cmd
startup.bat
```

### Step 3: Open the Application

Open your browser and navigate to:

```text
http://localhost:8080/InventoryManagementSite/
```

The application should now be accessible through your local Tomcat server.

## Future Enhancements

- User authentication and role-based access.
- Inventory reports and analytics.
- Export inventory data.
- Improved dashboard visualizations.
- Automated stock alerts.

## Author

Developed as an academic project to demonstrate Java web development, servlet-based application architecture, and database management.

**Technologies:** Java | JSP | Servlets | JDBC | MySQL | Apache Tomcat