package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Gastos;
import connection.Conn;

public class GastosController extends HttpServlet {

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
        String detalle = request.getParameter("detalle");
        String monto = request.getParameter("monto");
        String fecha = request.getParameter("fecha");
        //SACAR EL ID DEL USUARIO DESDE LA SESSION
                
        HttpSession session = request.getSession();
        String id_usuario = session.getAttribute("id_usuario").toString();
        
        String action = request.getParameter("action");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        Gastos gasto = new Gastos(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar gasto
                if (id != null && !id.isEmpty()) {
                    gasto.setId(Integer.parseInt(id));
                    gasto.deleteGasto();
                } else {
                    throw new RuntimeException("ID del gasto es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar gasto
                if (id != null && !id.isEmpty()) {
                    // Actualizar gasto existente
                    gasto.setId(Integer.parseInt(id));
                    gasto.setDetalle(detalle);
                    gasto.setMonto(Double.parseDouble(monto));
                    gasto.setFecha(fecha);                
                    gasto.setId_usuario(Integer.parseInt(id_usuario));
                    gasto.insertOrUpdateGasto();
                } else {
                    // Crear un nuevo gasto
                    gasto.setDetalle(detalle);
                    gasto.setMonto(Double.parseDouble(monto));
                    gasto.setFecha(fecha);                
                    gasto.setId_usuario(Integer.parseInt(id_usuario));
                    gasto.insertOrUpdateGasto();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar el gasto", e);
        }

        response.sendRedirect("./VistasController?vista=gastos");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing gastos";
    }

}
