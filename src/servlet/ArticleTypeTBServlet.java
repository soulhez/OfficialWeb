package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ArticleTypeTB;
public class ArticleTypeTBServlet extends HttpServlet {

	/**
	 * 文章类型servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			ArticleTypeTB articleTypeTB=null;//文章类型对象
			String method =request.getParameter("method");
			String aId=null;//文章类型ID
			//添加文章类型
			if(method.equalsIgnoreCase("add")){
				
			}//修改文章类型
			else if(method.equalsIgnoreCase("update")){
				
			}//删除文章类型
			else{
				
			}
	}
}
