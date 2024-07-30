package controller;

import java.io.IOException;
import connection.Conn;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");

        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);
        User user = new User(conn);

        try {
            if ("delete".equals(action)) {
                // Eliminar usuario
                if (id != null && !id.isEmpty()) {
                    user.setId(Integer.parseInt(id));
                    user.deleteUser();
                } else {
                    throw new RuntimeException("ID del usuario es necesario para eliminar.");
                }
            } else {
                // Crear o actualizar usuario
                if (id != null && !id.isEmpty()) {
                    // Actualizar usuario existente
                    user.setId(Integer.parseInt(id));
                    user.setName(nombre);
                    user.setEmail(correo);
                    user.setUsername(usuario);
                    if (clave != null && !clave.isEmpty()) {
                        user.setPassword(clave);
                    }
                    user.insertOrUpdateUser();
                } else {
                    // Crear un nuevo usuario
                    user.setName(nombre);
                    user.setEmail(correo);
                    user.setUsername(usuario);
                    user.setPassword(clave);
                    user.insertOrUpdateUser();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar el usuario", e);
        }

        response.sendRedirect("./VistasController?vista=usuarios");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing users";
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
