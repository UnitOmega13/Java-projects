package controller;

import factories.UserServiceFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/users")
public class UsersServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List allUsers = userService.getAll();
        request.setAttribute("allUsers", allUsers);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
