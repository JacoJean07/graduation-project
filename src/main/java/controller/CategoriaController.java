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
import model.Categoria;
import connection.Conn;

public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String detalle = request.getParameter("detalle");
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        Categoria categoria = new Categoria(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar categoria
                if (id != null && !id.isEmpty()) {
                    categoria.setId(Integer.parseInt(id));
                    categoria.deleteCategoria();
                } else {
                    throw new RuntimeException("ID de la categoria es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar categoria
                if (id != null && !id.isEmpty()) {
                    // Actualizar categoria existente
                    categoria.setId(Integer.parseInt(id));
                    categoria.setDetalle(detalle);
                    categoria.insertOrUpdateCategoria();
                } else {
                    // Crear una nueva categoria
                    categoria.setDetalle(detalle);
                    categoria.insertOrUpdateCategoria();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar la categoria", e);
        }

        response.sendRedirect("./VistasController?vista=categoria");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing categories";
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
