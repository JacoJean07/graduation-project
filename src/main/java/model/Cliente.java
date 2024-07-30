package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Cliente {

    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Conn conn;

    public Cliente(Conn conn) {
        this.conn = conn;
    }

    public Cliente() {
        // Constructor vacío para inicialización básica
    }

    public Cliente(int id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void insertOrUpdateCliente() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt;
            if (id > 0) {
                stmt = connection.prepareCall("{CALL update_cliente(?, ?, ?, ?)}");
                stmt.setInt(1, id);
                stmt.setString(2, nombre);
                stmt.setString(3, telefono);
                stmt.setString(4, direccion);
            } else {
                stmt = connection.prepareCall("{CALL insert_cliente(?, ?, ?)}");
                stmt.setString(1, nombre);
                stmt.setString(2, telefono);
                stmt.setString(3, direccion);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while inserting or updating Cliente.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }
    
    public void deleteCliente() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL delete_cliente(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while deleting Cliente.", e);
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
