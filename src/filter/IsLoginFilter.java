package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class IsLoginFilter implements Filter {
	private FilterConfig filterConfig=null;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		String loginFilterPath=filterConfig.getInitParameter("loginFilterPath");
		String[] paths=loginFilterPath.split(";");
		for (String path : paths) {
			if (path.contains("login.html")||path.equalsIgnoreCase("login.html")) {
				chain.doFilter(request, response);
			}else{
				if (request.getParameter("admin")==null) {
					response.sendRedirect("index.html");
					break;
				}
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		filterConfig=config;
	}
}
