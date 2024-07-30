package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Producto {

    private int id;
    private String codigo;
    private String descripcion;
    private double precioEntrada;
    private double precioSalida;
    private int existencia;
    private int id_categoria;
    private Conn conn;

    public Producto(Conn conn) {
        this.conn = conn;
    }

    public Producto() {
        // Constructor vacío para inicialización básica
    }

    public Producto(int id, String codigo, String descripcion, double precioEntrada, double precioSalida,
            int existencia, int id_categoria) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.existencia = existencia;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion; 
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public double getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void insertOrUpdateProducto() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt;
            if (id > 0) {
                stmt = connection.prepareCall("{CALL update_producto(?, ?, ?, ?, ?, ?, ?)}");
                stmt.setInt(1, id);
                stmt.setString(2, codigo);
                stmt.setString(3, descripcion);
                stmt.setDouble(4, precioEntrada);
                stmt.setDouble(5, precioSalida);
                stmt.setInt(6, existencia);                
                stmt.setInt(7, id_categoria);
            } else {
                stmt = connection.prepareCall("{CALL insert_producto(?, ?, ?, ?, ?, ?, ?)}");
                stmt.setString(1, codigo);
                stmt.setString(2, descripcion);
                stmt.setDouble(3, precioEntrada);
                stmt.setDouble(4, precioSalida);
                stmt.setInt(5, existencia);                
                stmt.setInt(6, id_categoria);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while inserting or updating Producto.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }

    public void deleteProducto() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL delete_producto(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while deleting Producto.", e);
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
