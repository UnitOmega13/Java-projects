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

@WebServlet(value = "/index")
public class MainPageServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(MainPageServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userExist(email, password)) {
            response.sendRedirect("/users");
            LOGGER.info("User " + email + " log in");
        } else {
            request.setAttribute("error", "Passwords incorrect");
            request.getRequestDispatcher("/index").forward(request, response);
            LOGGER.info("User " + email + " does not log in");
        }
    }

    private boolean userExist(String email, String password) {
        String userPassword = userService.getUserByEmail(email).getPassword();
        return password.equals(userPassword);
    }
}
