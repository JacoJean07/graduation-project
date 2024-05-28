package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3310/inventario";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
