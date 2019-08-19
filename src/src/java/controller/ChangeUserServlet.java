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

@WebServlet(value = "/products/edit")
public class ChangeUserServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ChangeProductServlet.class));
    private static final UserService userService = UserServiceFactory.getInstance();
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatedPassword");
        if (password.equals(repeatPassword) && !password.equals("")) {
            User oldUser = user;
            user.setEmail(email);
            user.setPassword(password);
            LOGGER.info("user " + oldUser + " was edited in the db");
            response.sendRedirect("/users");
        } else {
            request.setAttribute("passerror", "Passwords is incorrect");
            request.setAttribute("email", email);
            request.setAttribute("action", "/user/edit");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        user = (User) userService.getUserById(userId);
        request.setAttribute("email", user.getEmail());
        request.setAttribute("action", "/user/edit");
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
