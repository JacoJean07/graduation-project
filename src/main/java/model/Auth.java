package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Conn;

public class Auth {

    private String user;
    private String password;

    public Auth(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password, String user) {
        String sql = "SELECT password FROM usuarios WHERE user = ?";
        try (Connection connection = Conn.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    if (storedPassword.equals(password)) {

                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error verifying user", e);
        }

        return false;
    }


}
