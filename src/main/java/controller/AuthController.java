package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Auth;

import java.io.IOException;

public class AuthController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Auth auth = new Auth("jean", "admin");

        if (auth.checkUser(user) && auth.checkPassword(password)) {
            response.sendRedirect("main/index.jsp");
        } else {
            request.setAttribute("error", "<div class=\"alert alert-danger\" role=\"alert\">  <svg class=\"bi flex-shrink-0 me-2\" role=\"img\" aria-label=\"Danger:\" width=\"24\" height=\"24\"><use xlink:href=\"#exclamation-triangle-fill\"/></svg>\n"
                    + "                    Credenciales invalidas.\n"
                    + "                </div>");
            request.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
    }
}
