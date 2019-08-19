package controller;

import factories.BasketServiceFactory;
import factories.ProductServiceFactory;
import model.Product;
import model.User;
import service.BasketService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/products/buy")
public class BuyProductServlet extends HttpServlet {
    private static final ProductService productService = ProductServiceFactory.getInstance();
    private static final BasketService basketService = BasketServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> allProduct = productService.getAll();
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("allProduct", allProduct);
        if (!basketService.checkUserBasket(user)) {
            basketService.createBasket(user);
        }
        request.setAttribute("sizeOfBasket", basketService.getSizeOfBasket(user));
        request.getRequestDispatcher("/user_products.jsp").forward(request, response);
    }
}
