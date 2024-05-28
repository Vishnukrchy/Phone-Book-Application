package com.jspider.phone.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class PhoneConnection {

    public static Connection getDirectoryConnection() {
        Connection connection = null;
        try {
            // Create an instance of the MySQL driver
            Driver driver = new Driver();
            
            // Register the driver with DriverManager
            DriverManager.registerDriver(driver);
            
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/phonebook";
            String user = "root";
            String pass = "9999";
            
            // Establish the connection
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        }
        
        return connection;
    }

    public static void main(String[] args) {
        // Test the connection
        Connection conn = getDirectoryConnection();
        if (conn != null) {
            System.out.println("Connection established successfully.");
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
