package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UIUpdateServlet extends HttpServlet {
	

	/**
	 * 转修改页面的servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			String aId=request.getParameter("id");
			request.setAttribute("id",aId);
			//文章
			if(method==null||"".equals(method)){
				request.getRequestDispatcher("").forward(request, response);	
			}else if(method.equalsIgnoreCase("ArticleTypeTB")){
				//文章类型
				request.getRequestDispatcher("").forward(request, response);
			}else{
				//管理员修改页面
				request.getRequestDispatcher("").forward(request, response);
			}
	}
}
