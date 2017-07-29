package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IDServlet extends HttpServlet {
	

	/**
	 * 获取ID的servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			//根据文章类型ID查询文章后，以文章创建时间降序排列
			 if(method.equalsIgnoreCase("searchArticleTB")){
				
			}//根据文章ID查询文章
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				
			}
			 //根据导航ID查询文章类型集合
			else if(method.equalsIgnoreCase("searchArticleTypeTB")){
				
			}
			 //获取管理员信息
			else{
				
			}
	}
}
