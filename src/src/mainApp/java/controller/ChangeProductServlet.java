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
        long productId = Long.parseLong(request.getParameter("productId"));
        request.setAttribute("productId", productId);
        if (productService.getProduct(productId).isPresent()) {
            request.setAttribute("name",
                    productService.getProduct(productId).get().getName());
            request.setAttribute("description",
                    productService.getProduct(productId).get().getDescription());
            request.setAttribute("price",
                    productService.getProduct(productId).get().getPrice());
        }
            request.getRequestDispatcher("/new_product.jsp").forward(request, response);
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
