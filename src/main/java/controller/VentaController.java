package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Venta;
import connection.Conn;

public class VentaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String id = request.getParameter("id");
        String total = request.getParameter("total");
        String fecha = request.getParameter("fecha");
        String id_cliente = request.getParameter("id_cliente");
        String id_usuario = request.getParameter("id_usuario");
        String action = request.getParameter("action");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        Venta venta = new Venta(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar venta
                if (id != null && !id.isEmpty()) {
                    venta.setId(Integer.parseInt(id));
                    venta.deleteVenta();
                } else {
                    throw new RuntimeException("ID de la venta es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar venta
                if (id != null && !id.isEmpty()) {
                    // Actualizar venta existente
                    venta.setId(Integer.parseInt(id));
                    venta.setTotal(total);
                    venta.setFecha(fecha);
                    venta.setId_cliente(Integer.parseInt(id_cliente));
                    venta.setId_usuario(Integer.parseInt(id_usuario));
                    venta.InsertVenta();
                } else {
                    // Crear una nueva venta
                    venta.setTotal(total);
                    venta.setFecha(fecha);
                    venta.setId_cliente(Integer.parseInt(id_cliente));
                    venta.setId_usuario(Integer.parseInt(id_usuario));
                    venta.InsertVenta();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar la venta", e);
        }

        response.sendRedirect("./VistasController?vista=ventas");   
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing ventas";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

}
