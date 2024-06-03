package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Auth;

import java.io.IOException;

public class AuthController extends HttpServlet {
  //variables globales

  String inter1 = "index.jsp";
  String inter2 = "main/index.jsp";

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String user = request.getParameter("user");
    String password = request.getParameter("password");

    HttpSession session = request.getSession();
    Auth auth = (Auth) session.getAttribute("auth");
    if (auth == null) {
      auth = new Auth(user, password);
      session.setAttribute("auth", auth);
    } else {
      auth.setUser(user);
      auth.setPassword(password);
    }

    if (auth.checkPassword(password, user)) {
      response.sendRedirect(inter2);
    } else {
      request.setAttribute("error", "<div class=\"alert alert-danger\" role=\"alert\">  <svg class=\"bi flex-shrink-0 me-2\" role=\"img\" aria-label=\"Danger:\" width=\"24\" height=\"24\"><use xlink:href=\"#exclamation-triangle-fill\"/></svg>\n"
              + "                    Credenciales invalidas.\n"
              + "                </div>");
      request.setAttribute("user", user);
      request.getRequestDispatcher(inter1).forward(request, response);
    }
  }
}
