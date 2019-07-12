package controller.filter;

import controller.ChangeProductServlet;
import model.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserAccessFilter",
        urlPatterns = {"/user/*"})
public class UserAccessFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(ChangeProductServlet.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        String userRole = user.getAccessRole();
        if (userRole.equals("admin")) {
            LOGGER.info(user + " entered");
            chain.doFilter(request, response);
        } else {
            LOGGER.info(user + " access denied");
            httpRequest.getRequestDispatcher("/access").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
