
package com.infosis.jdbc_prepared_statement__crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LeptopConnection {

    // Step 1: Method to get a connection
    public static Connection getLeptopConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create the connection string
            String url = "jdbc:mysql://localhost:3306/jdbc_a5";
            String username = "root";
            String password = "India@1234";
            
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            
            // Print a message indicating the connection was successful
            System.out.println("Connection to the database was successful!");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
            e.printStackTrace();
        }
        
        // Return the connection, or null if an error occurred
        return connection;
    }
}
