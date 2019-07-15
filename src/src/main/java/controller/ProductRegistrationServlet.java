package controller;

import factories.ProductServiceFactory;
import model.Product;
import service.DataBase;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/new_product")
public class ProductRegistrationServlet extends HttpServlet {

    private static final ProductService PRODUCT_SERVICE = ProductServiceFactory.getInstance();
    private UUID id = UUID.randomUUID();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/new_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = -1;
        if (!request.getParameter("price").isEmpty()) {
            price = Double.valueOf(request.getParameter("price"));
        }
        if (name.isEmpty() || description.isEmpty() || price <= 0) {
            request.setAttribute("isEmpty", "All fields must be filled and price must be biggest than 0.");
            request.getServletContext().getRequestDispatcher("/new_product.jsp").forward(request, response);
        } else {
            PRODUCT_SERVICE.add(new Product(id, name, description, price));
            response.setStatus(HttpServletResponse.SC_OK);
            request.getRequestDispatcher("/products.jsp").forward(request, response);
        }
    }
}
