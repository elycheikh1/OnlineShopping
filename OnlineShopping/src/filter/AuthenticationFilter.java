package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/AddressController"}, servletNames = {"AddressController"})
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {}

	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
				
		if (req.getMethod().equalsIgnoreCase("GET") && session.getAttribute("user_info") == null) {
			res.sendRedirect("weblogin");			
		}
		else {
			chain.doFilter(req, res);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
