package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {
	private final AccountService accountService;

	public SignUpServlet(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@Override
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		String login = servletRequest.getParameter("login");
		String password = servletRequest.getParameter("login");
		servletResponse.setContentType("text/html;charset=utf-8");
		if (login != null) {
			accountService.addNewUser(new UserProfile(login, password, "unknown"));
			servletResponse.setStatus(HttpServletResponse.SC_OK);
		} else {
			servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
