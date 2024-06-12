/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import connection.Conn;

/**
 *
 * @author Jaco
 */
public class Vistas {

    private static ArrayList<Map<String, Object>> users = new ArrayList<>();
    private static ArrayList<Map<String, Object>> config = new ArrayList<>();
    private static ArrayList<Map<String, Object>> categorias = new ArrayList<>();
    private static ArrayList<Map<String, Object>> productos = new ArrayList<>();
    private static ArrayList<Map<String, Object>> clientes = new ArrayList<>();
    private static ArrayList<Map<String, Object>> ventas = new ArrayList<>();
    private static ArrayList<Map<String, Object>> lista_ventas = new ArrayList<>();

    public static void mostrarUsuarios() {
        try (Connection conn = Conn.getConnection(); PreparedStatement stmt = conn.prepareStatement("{CALL mostrar_usuarios}")) {
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
        }
    }

    public static void mostrarClientes() {
        try (Connection conn = Conn.getConnection(); PreparedStatement stmt = conn.prepareStatement("{CALL mostrar_clientes}")) {
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
        }
    }

    public static void mostrarCategorias() {
        try (Connection conn = Conn.getConnection(); PreparedStatement stmt = conn.prepareStatement("{CALL mostrar_categorias}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> categoria = new HashMap<>();
                categoria.put("id", rs.getInt("id"));
                categoria.put("detalle", rs.getString("detalle"));
                categoria.put("id_categoria", rs.getInt("id_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarProductos() {
        try (Connection conn = Conn.getConnection(); PreparedStatement stmt = conn.prepareStatement("{CALL mostrar_productos}")) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
