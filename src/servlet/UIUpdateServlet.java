package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ArticleTB;
import entity.ArticleTypeTB;
public class UIUpdateServlet extends HttpServlet {
	

	/**
	 * ת�޸�ҳ���servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			String aId=null;
			//����
			if(method.equalsIgnoreCase("articleTB")){
				
			}//��������
			else{
				
			}
	}
}
