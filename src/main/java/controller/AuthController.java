package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Auth;
import connection.Conn;

import java.io.IOException;

public class AuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String LOGIN_PAGE = "index.jsp";
    private final String MAIN_PAGE = "main/index.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSER = getServletContext().getInitParameter("jdbcUSER");
        String jdbcPASS = getServletContext().getInitParameter("jdbcPASS");
        
        Conn conn = new Conn(jdbcURL, jdbcUSER, jdbcPASS);

        HttpSession session = request.getSession();
        Auth auth = (Auth) session.getAttribute("auth");
        if (auth == null) {
            auth = new Auth(user, password, conn);
            session.setAttribute("auth", auth);
        } else {
            auth.setUser(user);
            auth.setPassword(password);
        }

        if (auth.checkPassword(password, user)) {
            String id_usuario = auth.getId();
            session.setAttribute("id_usuario", id_usuario);

            response.sendRedirect(MAIN_PAGE);
        } else {
            request.setAttribute("error", "<div class=\"alert alert-danger\" role=\"alert\">Credenciales inválidas.</div>");
            request.setAttribute("user", user);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
    }
}
