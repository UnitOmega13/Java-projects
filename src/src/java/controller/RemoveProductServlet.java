package controller;

import factories.ProductServiceFactory;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/products/remove")
public class RemoveProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceFactory.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.valueOf(request.getParameter("productId"));
        productService.removeProduct(productId);
        request.getRequestDispatcher("/products").forward(request, response);
    }
}
