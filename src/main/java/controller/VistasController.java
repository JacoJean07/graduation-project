package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VistasController extends HttpServlet {

    //usar rutas absolutas
    String usuarios = "main/usuarios.jsp";
    String config = "main/config.jsp";
    String categoria = "main/categoria.jsp";
    String productos = "main/productos.jsp";
    String clientes = "main/clientes.jsp";
    String ventas = "main/ventas.jsp";
    String lista_ventas = "main/lista_ventas.jsp";
    String index = "main/index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");



        // Obtener el valor del botón presionado
        String vista = request.getParameter("vista");

        // Determinar a qué vista redirigir
        String direccion = null;
        if (vista == null) {
            direccion = index;
        } else {
            switch (vista) {
                case "usuarios":
                    direccion = usuarios;
                    break;
                case "config":
                    direccion = config;
                    break;
                case "categoria":
                    direccion = categoria;
                    break;
                case "productos":
                    direccion = productos;
                    break;
                case "clientes":
                    direccion = clientes;
                    break;
                case "ventas":
                    direccion = ventas;
                    break;
                case "lista_ventas":
                    direccion = lista_ventas;
                    break;
                default:
                    direccion = index;
                    break;
            }
        }

        // Redirigir a la vista correspondiente con un redirect
        response.sendRedirect(direccion);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}