package controller;

import factories.UserServiceFactory;
import model.User;
import service.UserService;
import utils.IdGenerator;
import org.apache.commons.codec.digest.DigestUtils;
import utils.PasswordSaltGenerator;
import utils.SHA256HashUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration")
public class SignUpServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = IdGenerator.generateId();
        String salt = PasswordSaltGenerator.getSalt();
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = PasswordSaltGenerator.saltPassword(
                SHA256HashUtil.getSha256(req.getParameter("password")),
                SHA256HashUtil.getSha256(salt));
        String accessRole = req.getParameter("accessRole");
        String repeatedPassword = PasswordSaltGenerator.saltPassword(
                SHA256HashUtil.getSha256(req.getParameter("repeatedPassword")),
                SHA256HashUtil.getSha256(salt));
        if (email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Empty fields!");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        } else if (password.equals(repeatedPassword)) {
            String encryptedPassword = DigestUtils.sha256Hex(password);
            User user = new User(id, email, login, encryptedPassword, accessRole);
            resp.setStatus(HttpServletResponse.SC_OK);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Passwords are not same!");
            req.setAttribute("defaultLogin", login);
            req.setAttribute("defaultEmail", email);
            req.setAttribute("accessRole", accessRole);
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }
}
