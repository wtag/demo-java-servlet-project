package Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/dashboard", "/addproduct", "/editpassword", "/editproduct", "/updateproduct",
		"/deleteproduct" })
public class SessionFilter implements Filter {

	private ServletContext context;

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String userName = null;
		HttpSession session = request.getSession();
		if (session != null) {
			userName = (String) session.getAttribute("username");
		}
		if (null == userName) {
			response.sendRedirect("login.jsp");
		} else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
}
