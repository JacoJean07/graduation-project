package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import connection.Conn;

public class Vistas {

    private static ArrayList<Map<String, Object>> users = new ArrayList<>();
    private static ArrayList<Map<String, Object>> config = new ArrayList<>();
    private static ArrayList<Map<String, Object>> categorias = new ArrayList<>();
    private static ArrayList<Map<String, Object>> productos = new ArrayList<>();
    private static ArrayList<Map<String, Object>> clientes = new ArrayList<>();
    private static ArrayList<Map<String, Object>> ventas = new ArrayList<>();
    private static ArrayList<Map<String, Object>> lista_ventas = new ArrayList<>();
    private static ArrayList<Map<String, Object>> gastos = new ArrayList<>();
    private static ArrayList<Map<String, Object>> data = new ArrayList<>();
    private static ArrayList<Map<String, Object>> data2 = new ArrayList<>();
    private static Map<String, Object> row = new HashMap<>();

    private static Conn conn;

    // Métodos estáticos para establecer la conexión
    public static void setConn(Conn connection) {
        conn = connection;
    }

    public static void mostrarUsuarios() {
        data.clear();
        users.clear();
        row.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL get_users}");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("nombre", rs.getString("nombre"));
                user.put("correo", rs.getString("correo"));
                user.put("user", rs.getString("user"));
                user.put("password", rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(users);
    }

    public static void mostrarUsuario(int id) {
        row.clear();
        users.clear();

        Connection connection = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            conn.connect(); // Conecta a la base de datos
            connection = conn.getJdbcConnection();

            // Llama al procedimiento almacenado con un parámetro
            stmt = connection.prepareCall("{CALL get_user(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("nombre", rs.getString("nombre"));
                user.put("correo", rs.getString("correo"));
                user.put("user", rs.getString("user"));
                user.put("password", rs.getString("password"));
                row = user; // Añadir directamente al resultado esperado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos en orden inverso de apertura
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarClientes() {
        row.clear();
        data.clear();
        clientes.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL get_clientes}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> cliente = new HashMap<>();
                cliente.put("id", rs.getInt("id"));
                cliente.put("nombre", rs.getString("nombre"));
                cliente.put("telefono", rs.getString("telefono"));
                cliente.put("direccion", rs.getString("direccion"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(clientes);
    }

    public static void mostrarCliente(int id) {
        row.clear();
        clientes.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL get_cliente(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> cliente = new HashMap<>();
                cliente.put("id", rs.getInt("id"));
                cliente.put("nombre", rs.getString("nombre"));
                cliente.put("telefono", rs.getString("telefono"));
                cliente.put("direccion", rs.getString("direccion"));
                row = cliente; // Añadir directamente al resultado esperado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarCategorias() {
        row.clear();
        data.clear();
        categorias.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_categorias}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> categoria = new HashMap<>();
                categoria.put("id", rs.getInt("id"));
                categoria.put("detalle", rs.getString("detalle"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(categorias);
    }

    public static void mostrarCategoria(int id) {
        row.clear();
        categorias.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL get_categoria(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> categoria = new HashMap<>();
                categoria.put("id", rs.getInt("id"));
                categoria.put("detalle", rs.getString("detalle"));
                row = categoria; // Añadir directamente al resultado esperado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarProductos() {
        row.clear();
        data.clear();
        productos.clear();
        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_productos}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> producto = new HashMap<>();
                producto.put("id", rs.getInt("id"));
                producto.put("codigo", rs.getString("codigo"));
                producto.put("descripcion", rs.getString("descripcion"));
                producto.put("precioEntrada", rs.getDouble("precioEntrada"));
                producto.put("precioSalida", rs.getDouble("precioSalida"));
                producto.put("existencia", rs.getInt("existencia"));
                producto.put("id_categoria", rs.getInt("id_categoria"));
                productos.add(producto);
            }
            CallableStatement stmt2 = connection.prepareCall("{CALL get_categorias}");
            ResultSet rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                Map<String, Object> categoria = new HashMap<>();
                categoria.put("id", rs2.getInt("id"));
                categoria.put("detalle", rs2.getString("detalle"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(productos);
        data2.addAll(categorias);
    }

    public static void mostrarProducto(int id) {
        row.clear();
        productos.clear();

        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();

            CallableStatement stmt = connection.prepareCall("{CALL get_producto(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> producto = new HashMap<>();
                producto.put("id", rs.getInt("id"));
                producto.put("codigo", rs.getString("codigo"));
                producto.put("descripcion", rs.getString("descripcion"));
                producto.put("precioEntrada", rs.getDouble("precioEntrada"));
                producto.put("precioSalida", rs.getDouble("precioSalida"));
                producto.put("existencia", rs.getInt("existencia"));
                producto.put("id_categoria", rs.getInt("id_categoria"));
                row = producto; // Añadir directamente al resultado esperado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarVentas() {
        data.clear();
        ventas.clear();
        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_ventas}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> venta = new HashMap<>();
                venta.put("id", rs.getInt("id"));
                venta.put("total", rs.getDouble("total"));
                venta.put("fecha", rs.getString("fecha"));
                venta.put("id_cliente", rs.getInt("id_cliente"));
                venta.put("id_usuario", rs.getInt("id_usuario"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(ventas);
    }

    public static void mostrarGastos() {
        data.clear();
        gastos.clear();
        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_gastos}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> gasto = new HashMap<>();
                gasto.put("id", rs.getInt("id"));
                gasto.put("detalle", rs.getString("detalle"));
                gasto.put("monto", rs.getDouble("monto"));
                gasto.put("fecha", rs.getString("fecha"));
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(gastos);
    }

    public static void mostrarConfiguracion() {
        data.clear();
        config.clear();
        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_configuracion}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> configuracion = new HashMap<>();
                configuracion.put("id", rs.getInt("id"));
                configuracion.put("nombre", rs.getString("nombre"));
                configuracion.put("telefono", rs.getString("telefono"));
                configuracion.put("email", rs.getString("email"));
                configuracion.put("direccion", rs.getString("direccion"));
                config.add(configuracion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(config);
    }

    public static void mostrarListaVentas() {
        data.clear();
        lista_ventas.clear();
        try {
            conn.connect(); // Conecta a la base de datos
            Connection connection = conn.getJdbcConnection();
            CallableStatement stmt = connection.prepareCall("{CALL get_ventas}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> venta = new HashMap<>();
                venta.put("id", rs.getInt("id"));
                venta.put("total", rs.getDouble("total"));
                venta.put("fecha", rs.getString("fecha"));
                venta.put("id_cliente", rs.getInt("id_cliente"));
                venta.put("id_usuario", rs.getInt("id_usuario"));
                lista_ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.disconnect(); // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        data.addAll(lista_ventas);
    }

    public static ArrayList<Map<String, Object>> getData() {
        return data;
    }

    public static ArrayList<Map<String, Object>> getData2() {
        return data2;
    }

    public static Map<String, Object> getRow() {
        if (row.isEmpty()) {
            return null;
        } else {
            return row;
        }
    }
}
