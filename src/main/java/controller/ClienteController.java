/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import connection.Conn;

public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        Cliente cliente = new Cliente(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar cliente
                if (id != null && !id.isEmpty()) {
                    cliente.setId(Integer.parseInt(id));
                    cliente.deleteCliente();
                } else {
                    throw new RuntimeException("ID del cliente es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar cliente
                if (id != null && !id.isEmpty()) {
                    // Actualizar cliente existente
                    cliente.setId(Integer.parseInt(id));
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.insertOrUpdateCliente();
                } else {
                    // Crear un nuevo cliente
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.insertOrUpdateCliente();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar el cliente", e);
        }

        response.sendRedirect("./VistasController?vista=clientes");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

}
