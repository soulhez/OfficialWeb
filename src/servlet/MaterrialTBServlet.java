package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaterrialTBServlet extends HttpServlet {

	/**
	 * 素材servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			//根据素材类型查询一个素材的名称
			if(method.equalsIgnoreCase("name")){
				
			}
			//根据素材类型查询此类型的素材集合
			else{
				
			}
	}
}
