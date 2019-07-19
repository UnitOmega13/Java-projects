package controller;

import factories.BasketServiceFactory;
import factories.MailServiceFactory;
import model.OrderDetails;
import model.Product;
import model.User;
import service.BasketService;
import service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/order")
public class OrderServlet extends HttpServlet {
    private static final BasketService basketService = BasketServiceFactory.getInstance();
    private static final MailService mailService = MailServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (basketService.getUserBasket(user).isPresent()){
            List<Optional<Product>> allProductInBasket = basketService.getUserBasket(user).get().getProducts();
            request.setAttribute("allProductInBasket", allProductInBasket);
        }
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        OrderDetails order = new OrderDetails(request.getParameter("name"),
                request.getParameter("lastName"),
                user.getEmail(),
                request.getParameter("delivery"),
                request.getParameter("country"),
                request.getParameter("city"),
                request.getParameter("phoneNumber"));
        request.getSession().setAttribute("order", order);
        user.setCode();
        mailService.sendCode(user);
        response.sendRedirect("/confirm_order");
    }
}
