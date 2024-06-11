package controller.usuarios;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Register;

public class RegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

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

        Register user = new Register();
        user.setName(nombre);
        user.setEmail(correo);
        user.setUsername(usuario);
        user.setPassword(clave);

        try {
            user.insertUser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("../main/usuarios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for registering new users";
    }
}