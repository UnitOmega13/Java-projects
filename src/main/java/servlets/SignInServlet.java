package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
	private final AccountService accountService;
	public SignInServlet(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@Override
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
		String login = servletRequest.getParameter("login");
		servletResponse.setContentType("text/html;charset=utf-8");
		UserProfile userByLogin = accountService.getUserByLogin(login);
		if (userByLogin != null) {
			if (userByLogin.getLogin().equals(login)) {
				servletResponse.setStatus(HttpServletResponse.SC_OK);
				servletResponse.getWriter().print("Authorized: " + login);
			} else {
				servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				servletResponse.getWriter().print("Unauthorized");
			}
		}

	}
}
