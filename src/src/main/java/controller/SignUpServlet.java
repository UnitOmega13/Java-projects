package controller;

import factories.AccountServiceFactory;
import model.User;
import dao.impl.UsersDAO;
import service.AccountService;
import factories.UserDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private static final UsersDAO USERS_DAO = UserDAOFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {
        servletRequest.getServletContext().getRequestDispatcher("/registration.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatedPassword");
        if (email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Empty fields!");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }else if (password.equals(repeatedPassword)) {
            User user = UsersDAO.create(email, login, password);
            USERS_DAO.add(user);
            resp.setStatus(HttpServletResponse.SC_OK);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } else {
            req.setAttribute("ERROR!!!", "Passwords are not same!");
            req.setAttribute("defaultLogin", login);
            req.setAttribute("defaultEmail", email);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
