
package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Categoria {

    private int id;
    private String detalle;
    private Conn conn;

    public Categoria() {
        // Constructor vacío para inicialización básica
    }

    public Categoria(Conn conn) {
        this.conn = conn;
    }
    
    public Categoria(int id, String detalle, int id_categoria) {
        this.id = id;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public void insertOrUpdateCategoria() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt;
            if (id > 0) {
                stmt = connection.prepareCall("{CALL update_categoria(?, ?)}");
                stmt.setInt(1, id);
                stmt.setString(2, detalle);
            } else {
                stmt = connection.prepareCall("{CALL insert_categoria(?)}");
                stmt.setString(1, detalle);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while inserting or updating Categoria.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }

    public void deleteCategoria() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL delete_categoria(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while deleting Categoria.", e);
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
