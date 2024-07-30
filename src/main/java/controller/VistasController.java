package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

import connection.Conn;
import model.Vistas;

public class VistasController extends HttpServlet {

    // Rutas absolutas
    private static final String USUARIOS = "main/usuarios.jsp";
    private static final String CONFIG = "main/config.jsp";
    private static final String CATEGORIA = "main/categoria.jsp";
    private static final String PRODUCTOS = "main/productos.jsp";
    private static final String CLIENTES = "main/clientes.jsp";
    private static final String VENTAS = "main/ventas.jsp";
    private static final String LISTA_VENTAS = "main/lista_ventas.jsp";
    private static final String INDEX = "main/index.jsp";
    private static final String GASTOS = "main/gastos.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String vista = request.getParameter("vista");
        Conn conn = createConnection();

        Vistas.setConn(conn);

        String direccion = resolveView(vista, request);
        ArrayList<Map<String, Object>> data = Vistas.getData();
        ArrayList<Map<String, Object>> data2 = Vistas.getData2();
        Map<String, Object> row = Vistas.getRow();

        HttpSession session = request.getSession();
        session.setAttribute("data", data);
        session.setAttribute("data2", data2);
        session.setAttribute("row", row);

        response.sendRedirect(direccion);
    }

    private Conn createConnection() {
        // Obtener los parámetros de conexión desde web.xml
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        return new Conn(jdbcURL, jdbcUSER, jdbcPASS);
    }

    private String resolveView(String vista, HttpServletRequest request) {
        String id = request.getParameter("id");

        if (vista == null) {
            return INDEX;
        }

        switch (vista) {
            case "usuarios":
                Vistas.mostrarUsuarios();
                if (id != null) {
                    Vistas.mostrarUsuario(Integer.parseInt(id));
                }
                return USUARIOS;
            case "config":
                Vistas.mostrarConfiguracion();
                return CONFIG;
            case "categoria":
                Vistas.mostrarCategorias();
                if (id != null) {
                    Vistas.mostrarCategoria(Integer.parseInt(id));
                }
                return CATEGORIA;
            case "productos":
                Vistas.mostrarProductos();
                if (id != null) {
                    Vistas.mostrarProducto(Integer.parseInt(id));
                }
                return PRODUCTOS;
            case "clientes":
                Vistas.mostrarClientes();
                if (id != null) {
                    Vistas.mostrarCliente(Integer.parseInt(id));
                }
                return CLIENTES;
            case "ventas":
                return VENTAS;
            case "lista_ventas":
                Vistas.mostrarListaVentas();
                return LISTA_VENTAS;
            case "gastos":
                Vistas.mostrarGastos();
                return GASTOS;
            default:
                return INDEX;
        }
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
