package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Conn;

public class Auth {

    private String user;
    private String password;
    private Conn conn;

    public Auth(String user, String password, Conn conn) {
        this.user = user;
        this.password = password;
        this.conn = conn;
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
        try {
            conn.connect();
            Connection connection = conn.getJdbcConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    return storedPassword.equals(password);
                }
            }
            statement.close();
            conn.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException("Error verifying user", e);
        }

        return false;
    }
}
