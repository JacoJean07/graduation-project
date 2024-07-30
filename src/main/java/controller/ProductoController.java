package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import connection.Conn;

public class ProductoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String id = request.getParameter("id");
        String codigo = request.getParameter("codigo");
        String descripcion = request.getParameter("descripcion");
        String precioEntrada = request.getParameter("precioEntrada");
        String precioSalida = request.getParameter("precioSalida");
        String existencia = request.getParameter("existencia");
        String idCategoria = request.getParameter("idCategoria");
        String action = request.getParameter("action");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        Producto producto = new Producto(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar producto
                if (id != null && !id.isEmpty()) {
                    producto.setId(Integer.parseInt(id));
                    producto.deleteProducto();
                } else {
                    throw new RuntimeException("ID del producto es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar producto
                if (id != null && !id.isEmpty()) {
                    // Actualizar producto existente
                    producto.setId(Integer.parseInt(id));
                    producto.setCodigo(codigo);
                    producto.setDescripcion(descripcion);
                    producto.setPrecioEntrada(Double.parseDouble(precioEntrada));
                    producto.setPrecioSalida(Double.parseDouble(precioSalida));
                    producto.setExistencia(Integer.parseInt(existencia));
                    producto.setId_categoria(Integer.parseInt(idCategoria));
                    producto.insertOrUpdateProducto();
                } else {
                    // Crear un nuevo producto
                    producto.setCodigo(codigo);
                    producto.setDescripcion(descripcion);
                    producto.setPrecioEntrada(Double.parseDouble(precioEntrada));
                    producto.setPrecioSalida(Double.parseDouble(precioSalida));
                    producto.setExistencia(Integer.parseInt(existencia));
                    producto.setId_categoria(Integer.parseInt(idCategoria));
                    producto.insertOrUpdateProducto();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar el producto", e);
        }

        response.sendRedirect("./VistasController?vista=productos");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing products";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

}
