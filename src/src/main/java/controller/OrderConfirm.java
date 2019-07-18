package controller;

import factories.BasketServiceFactory;
import factories.MailServiceFactory;
import factories.OrderDetailsFactory;
import model.OrderDetails;
import model.User;
import service.BasketService;
import service.MailService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/confirm")
public class OrderConfirm extends HttpServlet {
    private static final OrderService orderService = OrderDetailsFactory.getInstance();
    private static final BasketService basketService = BasketServiceFactory.getInstance();
    private static final MailService mailService = MailServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/confirm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codeFromPage = request.getParameter("code");
        User user = (User) request.getSession().getAttribute("user");
        if (user.getCode().equals(codeFromPage)) {
            orderService.addOrder((OrderDetails) request.getSession().getAttribute("order"));
            mailService.sendOrder(user, (OrderDetails) request.getSession().getAttribute("order"));
            basketService.clearBasket(user);
            response.sendRedirect("/product/buy");
        } else {
            request.setAttribute("error", "Wrong code! Check mail and try again!");
            request.getRequestDispatcher("/confirm.jsp").forward(request, response);
        }
    }
}
