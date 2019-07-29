package controller;

import factories.BasketServiceFactory;
import model.Product;
import model.User;
import service.BasketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/basket/buy")
public class BasketServlet  extends HttpServlet {
    private static final BasketService basketService = BasketServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (basketService.getUserBasket(user).isPresent()){
            List<Product> allProductInBasket = basketService.getUserBasket(user).get().getProducts();
            request.setAttribute("allProductInBasket", allProductInBasket);
        }
        request.getRequestDispatcher("/basket.jsp").forward(request, response);
    }
}
