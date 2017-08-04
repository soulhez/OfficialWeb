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
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		String loginFilterPath=filterConfig.getInitParameter("loginFilterPath");
		String[] paths=loginFilterPath.split(";");
		String pathString=request.getRequestURI();
		Boolean floag=true;
		for (String path : paths) {
			if (pathString.indexOf(path)>-1||pathString.equalsIgnoreCase(path)) {
				floag=false;
			}
		}
//		if(floag){
//			if (request.getSession().getAttribute("admin")==null) {
//				response.sendRedirect("index.html");
//			}else{
//				chain.doFilter(request, response);	
//			}
//		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		filterConfig=config;
	}
}
