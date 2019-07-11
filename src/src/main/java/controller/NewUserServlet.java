package controller;

import factories.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewUserServlet", value = "/users/add")
public class NewUserServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String accessRole = request.getParameter("accessRole");
        String password = request.getParameter("password");
        String reEnteredPassword = request.getParameter("repeatedPassword");
        if (password.equals(reEnteredPassword)) {
            User user = new User(login, email, password, accessRole);
            userService.add(user);
            response.sendRedirect("/users");
        } else {
            request.setAttribute("error", "Passwords are not equals");
            request.setAttribute("email", email);
            request.setAttribute("accessRole", accessRole);
            request.setAttribute("action", "/users/add");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "/users/add");
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
