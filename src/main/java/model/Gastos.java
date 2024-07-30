
package model;

import connection.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Gastos {
    
    private int id;
    private String detalle;
    private double monto;
    private String fecha;
    private int id_usuario;
    private Conn conn;
    
    public Gastos() {
        
    }

    public Gastos(int id, String detalle, double monto, String fecha, int id_usuario) {
        this.id = id;
        this.detalle = detalle;
        this.monto = monto;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
    }

    public Gastos(Conn conn) {
        this.conn = conn;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void insertOrUpdateGasto() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt;
            if (id > 0) {
                stmt = connection.prepareCall("{CALL update_gasto(?, ?, ?, ?, ?)}");
                stmt.setInt(1, id);
                stmt.setString(2, detalle);
                stmt.setDouble(3, monto);
                stmt.setString(4, fecha);
                stmt.setInt(5, id_usuario);
            } else {
                stmt = connection.prepareCall("{CALL insert_gasto(?, ?, ?, ?)}");
                stmt.setString(1, detalle);
                stmt.setDouble(2, monto);
                stmt.setString(3, fecha);
                stmt.setInt(4, id_usuario);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while inserting or updating gasto.", e);
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error occurred while disconnecting.", e);
            }
        }
    }

    public void deleteGasto() {
        if (conn == null) {
            throw new RuntimeException("Connection object is not initialized.");
        }

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL delete_gasto(?)}");
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL error occurred while deleting gasto.", e);
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
