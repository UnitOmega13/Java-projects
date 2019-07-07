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
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {
        String login = servletRequest.getParameter("login");
        String email = servletRequest.getParameter("email");
        String password = servletRequest.getParameter("password");
        String repeatedPassword = servletRequest.getParameter("repeatedPassword");
        if (password.equals(repeatedPassword)) {
            User user = UsersDAO.create(email, login, password);
            USERS_DAO.add(user);
            servletResponse.setStatus(HttpServletResponse.SC_OK);
            servletRequest.getRequestDispatcher("/users.jsp").forward(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("ERROR!!!", "Passwords are not same!");
            servletRequest.setAttribute("defaultLogin", login);
            servletRequest.setAttribute("defaultEmail", email);
            servletRequest.getRequestDispatcher("/registration.jsp").forward(servletRequest, servletResponse);
        }
    }
}
