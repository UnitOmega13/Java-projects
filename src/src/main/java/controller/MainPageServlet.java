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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/index")
public class MainPageServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(MainPageServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.getUserByEmail(email);
        if (userExist(password, user)) {
            session.setAttribute("user", user);
            response.sendRedirect("/users");
            LOGGER.info("User " + email + " got access to the site");
        } else {
            request.setAttribute("error", "Password or email incorrect");
            request.getRequestDispatcher("/index").forward(request, response);
            LOGGER.info("User " + email + " login");
        }
    }

    private boolean userExist(String password, User user) {
        String userPassword = user.getPassword();
        return password.equals(userPassword);
    }
}
