package controller;

import factories.ProductServiceFactory;
import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet(value = "/products/edit")
public class ChangeProductServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ChangeProductServlet.class));
    private static final ProductService productService = ProductServiceFactory.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long productId = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));
        Optional<Product> optionalProduct = productService.getProduct(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            LOGGER.info("product " + product + " was edited in the db");
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            response.sendRedirect("/products");
        }else {
            request.setAttribute("error", "No such product.");
            request.setAttribute("name", name);
            request.setAttribute("description", description);
            request.setAttribute("price", price);
            request.setAttribute("action", "/product/add");
            request.getRequestDispatcher("/new_product.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long productId = Long.valueOf(request.getParameter("id"));
        Optional<Product> optionalProduct = productService.getProduct(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            request.setAttribute("productId", productId);
            request.setAttribute("name", product.getName());
            request.setAttribute("description", product.getDescription());
            request.setAttribute("price", product.getPrice());
            request.setAttribute("action", "/product/edit");
            request.getRequestDispatcher("/new_product.jsp").forward(request, response);
        }
    }
}
