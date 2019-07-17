package controller;

import factories.UserServiceFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/admin/users/delete")
public class RemoveUserServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        long userId = Long.valueOf(request.getParameter("userId"));
        userService.removeUser(userId);
        request.getRequestDispatcher("/admin/users").forward(request, response);
    }
}
