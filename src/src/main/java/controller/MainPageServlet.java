package controller;

import factories.UserServiceFactory;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import service.UserService;
import utils.PasswordSaltGenerator;
import utils.SHA256HashUtil;

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

    @Test
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        Optional<User> optionalUser = userService.getUserByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String encryptedPassword = SHA256HashUtil.getSha256(PasswordSaltGenerator.saltPassword(
                    request.getParameter("repeatedPassword"), user.getSalt());
            if(user.getPassword().equals(encryptedPassword))
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
}
