package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int id;
    private String name;
    private String email;
    private String username;
    private String passwordHash;
    private String action;
    private Conn conn;

    public User() {
        // Constructor vacío para inicialización básica
    }

    public User(Conn conn) {
        this.conn = conn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void insertOrUpdateUser() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt;
            if (id > 0) {
                stmt = connection.prepareCall("{CALL update_user(?, ?, ?, ?)}");
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setString(3, email);
                stmt.setString(4, username);
            } else {
                stmt = connection.prepareCall("{CALL insert_user(?, ?, ?, ?)}");
                
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, username);
                stmt.setString(4, passwordHash);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while inserting or updating user.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }

    public void deleteUser() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL delete_user(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while deleting user.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }
}
