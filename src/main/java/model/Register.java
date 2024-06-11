package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class Register {

    private String name;
    private String email;
    private String username;
    private String passwordHash;

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

    public void insertUser() {
        try (Connection conn = Conn.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL insert_user(?, ?, ?, ?)}");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, passwordHash);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}