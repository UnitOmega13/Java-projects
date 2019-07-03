package controller;

import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private static final AccountService ACCOUNT_SERVICE = AccountService.instance();

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {
        if (ACCOUNT_SERVICE.isLogin()) {
            servletResponse.sendRedirect("/pokupka");
            return;
        }
        servletRequest.setAttribute("login", "Sign up");
        servletRequest.setAttribute("registration", "Registration");
        servletRequest.getServletContext().getRequestDispatcher("/Registration.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        String repeatedPassword = servletRequest.getParameter("repeatedPassword");
        if (ACCOUNT_SERVICE.signUp(login, password, repeatedPassword)) {
            servletResponse.sendRedirect("/MainPage");
        } else {
            servletRequest.setAttribute("Error", "User already exists or passwords are different");
            servletRequest.setAttribute("login", "Sign up");
            servletRequest.setAttribute("registration", "Registration");
            servletRequest.getServletContext().getRequestDispatcher("/Registration.jsp").forward(servletRequest, servletResponse);
        }
    }
}
