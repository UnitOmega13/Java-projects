package controller;

import factories.ProductServiceFactory;
import model.Product;
import model.User;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(value = "/users/edit")
public class ChangeProductServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ChangeProductServlet.class));
    private static final ProductService productService = ProductServiceFactory.getInstance();
    private Product product;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));
        Product oldProduct = product;
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        LOGGER.info("product " + oldProduct + " was edited in the db");
        response.sendRedirect("/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long productId = Long.valueOf(request.getParameter("productId"));
        product = (Product) productService.getProduct(productId);
        request.setAttribute("name", product.getName());
        request.setAttribute("description", product.getDescription());
        request.setAttribute("price", product.getPrice());
        request.setAttribute("action", "/edit/product");
        request.getRequestDispatcher("/add_product.jsp").forward(request, response);
    }
}
