package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleTypeTBDaoImpl;

import util.WebUtils;

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
			int number=0;
			PrintWriter out=response.getWriter();
			//�����������
			if(method.equalsIgnoreCase("add")){
				articleTypeTB=WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
				if(number>0){
					out.write("��ӳɹ�");
					return;
				}else{
					out.write("���ʧ��");
					return;
				}
				
			}//�޸���������
			else if(method.equalsIgnoreCase("update")){
				articleTypeTB= WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB);
				if(number>0){
					out.write("�޸ĳɹ�");
					return;
				}else{
					out.write("�޸�ʧ��");
					return;
				}
			}//ɾ����������
			else{
				 aId=request.getParameter("id");
				number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB(aId);
				if (number>0) {
					out.write("ɾ���ɹ�");
					return;
				}else{
					out.write("ɾ��ʧ��");
					return;
				}
			}
	}
}
