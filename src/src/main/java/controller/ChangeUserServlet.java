package controller;

import factories.UserServiceFactory;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/admin/users/edit")
public class ChangeUserServlet extends HttpServlet {
    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        request.setAttribute("userId", productId);
        if (userService.getUserById(productId).isPresent()) {
            request.setAttribute("email",
                    userService.getUserById(productId).get().getEmail());
            request.setAttribute("login",
                    userService.getUserById(productId).get().getLogin());
            request.setAttribute("password",
                    userService.getUserById(productId).get().getPassword());
            request.setAttribute("role",
                    userService.getUserById(productId).get().getAccessRole());
        }
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            setUserAttributes(userId, user.getEmail(), user.getLogin(), user.getAccessRole(), request);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }

    private void setUserAttributes(Long userId, String email, String login, String accessRole,
                                   HttpServletRequest request) {
        request.setAttribute("userId", userId);
        request.setAttribute("email", email);
        request.setAttribute("login", login);
        request.setAttribute("accessRole", accessRole);
        request.setAttribute("action", "/admin/users/edit");
    }
}
