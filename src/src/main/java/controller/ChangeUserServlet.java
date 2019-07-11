package controller;

import factories.UserServiceFactory;
import model.User;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/users/edit")
public class ChangeUserServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ChangeProductServlet.class));
    private static final UserService userService = UserServiceFactory.getInstance();
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatedPassword");
        String accessRole = request.getParameter("accessRole");
        if (password.equals(repeatPassword) && !password.equals("")) {
            User oldUser = user;
            user.setEmail(email);
            user.setPassword(password);
            user.setAccessRole(accessRole);
            LOGGER.info("user " + oldUser + " was edited in the db");
            response.sendRedirect("/users");
        } else {
            request.setAttribute("error", "Passwords is incorrect");
            request.setAttribute("email", email);
            request.setAttribute("accessRole", accessRole);
            request.setAttribute("action", "/users/edit");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        user = (User) userService.getUserById(userId);
        request.setAttribute("email", user.getEmail());
        request.setAttribute("action", "/users/edit");
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
