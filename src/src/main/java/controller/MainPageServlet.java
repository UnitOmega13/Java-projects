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
import java.util.Optional;

@WebServlet(value = "/index")
public class MainPageServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(MainPageServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<User> optionalUser = userService.getUserByEmail(email);
        if (optionalUser.isPresent() && passwordCheck(password, optionalUser.get())) {
            session.setAttribute("user", optionalUser.get());
            if (optionalUser.get().getAccessRole().equals("admin")){
                response.sendRedirect("/admin/users");
            } else {
                response.sendRedirect("/products");
            }
            LOGGER.info("User " + email + " got access to the site");
        } else {
            request.setAttribute("error", "Password or email incorrect");
            request.getRequestDispatcher("/").forward(request, response);
            LOGGER.info("User " + email + " does not enter");
        }
    }

    private boolean passwordCheck(String password, User user) {
        String userPassword = user.getPassword();
        return password.equals(userPassword);
    }
}
