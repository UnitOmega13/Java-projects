package controller;

import factories.ProductServiceFactory;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/products/delete")
public class RemoveProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        UUID productId = UUID.fromString(request.getParameter("productId"));
        productService.removeProduct(productId);
        request.getRequestDispatcher("/products").forward(request, response);
    }
}
