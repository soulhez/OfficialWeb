package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ArticleTypeTB;
public class ArticleTypeTBServlet extends HttpServlet {

	/**
	 * ��������servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			ArticleTypeTB articleTypeTB=null;//�������Ͷ���
			String method =request.getParameter("method");
			String aId=null;//��������ID
			//�����������
			if(method.equalsIgnoreCase("add")){
				
			}//�޸���������
			else if(method.equalsIgnoreCase("update")){
				
			}//ɾ����������
			else{
				
			}
	}
}
