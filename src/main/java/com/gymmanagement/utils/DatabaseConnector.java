
package com.gymmanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // Database configuration
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "gymdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // Set your password here

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE,
                        USERNAME,
                        PASSWORD
                );
                System.out.println("Database connection established.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.err.println("Database connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Failed to close the database connection: " + e.getMessage());
            }
        }
    }
}
