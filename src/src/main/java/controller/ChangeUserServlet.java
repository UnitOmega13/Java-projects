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
import java.util.Optional;
import java.util.UUID;

@WebServlet(value = "/admin/users/edit")
public class ChangeUserServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ChangeProductServlet.class));
    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UUID userId = UUID.fromString(request.getParameter("userId"));
        String email = request.getParameter("email");
        String accessRole = request.getParameter("accessRole");
        String password = request.getParameter("password");
        String reEnteredPassword = request.getParameter("repeatedPassword");
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent() &&
                password.equals(reEnteredPassword) &&
                !password.isEmpty()) {
            User user = optionalUser.get();
            user.setEmail(email);
            user.setAccessRole(accessRole);
            user.setPassword(password);
            LOGGER.info("user " + user + " was edited");
            response.sendRedirect("/admin/users");
        } else if (!optionalUser.isPresent()) {
            request.setAttribute("error", "No such user in data base");
            setUserAttributes(userId, email, accessRole, request);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Your passwords are incorrect");
            setUserAttributes(userId, email, accessRole, request);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UUID userId = UUID.fromString(request.getParameter("userId"));
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            setUserAttributes(userId, user.getEmail(), user.getAccessRole(), request);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    private void setUserAttributes(UUID userId, String email, String accessRole,
                                   HttpServletRequest request) {
        request.setAttribute("userId", userId);
        request.setAttribute("email", email);
        request.setAttribute("accessRole", accessRole);
        request.setAttribute("action", "/admin/users/edit");
    }
}
