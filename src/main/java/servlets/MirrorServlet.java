package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MirrorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
		String message = servletRequest.getParameter("key");
		servletResponse.setContentType("text/html;charset=utf-8");
		if (message == null || message.isEmpty()) {
			servletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			servletResponse.setStatus(HttpServletResponse.SC_OK);
		}
		servletResponse.getWriter().print(message);
	}
}
