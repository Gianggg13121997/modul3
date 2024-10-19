package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HotelManager";
    private static final String USER = "root";
    private static final String PASSWORD = "giang123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
