package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleTBDaoImpl;

import util.WebUtils;

import entity.ArticleTB;

public class ArticleTBServlet extends HttpServlet {

	/**
	 * ����servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			ArticleTB articleTB=null;//���¶���
			String aId=null;//����id
			String aArticleTypetbID=null;//��������id
			String method =request.getParameter("method");
			PrintWriter out=response.getWriter();
			//�������
			if (method.equalsIgnoreCase("add")) {
				articleTB=new WebUtils().beanFrom(request, ArticleTB.class);
				int number=new ArticleTBDaoImpl().addArticleTB(articleTB);
				if (number>0) {
					out.write("��ӳɹ�");
					return;
				}else{
					out.write("���ʧ��");
					return;
				}
			}//��������IDɾ������
			else if(method.equalsIgnoreCase("delete")){
				
			}//��������ID�޸�����
			else if(method.equalsIgnoreCase("update")){
				
			}//������������ID��ѯ���º������´���ʱ�併������
			else if(method.equalsIgnoreCase("searchArticleTB")){
				
			}//��������ID��ѯ����
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				
			}//��������id��ѯ��������
			else{
				
			}
	}
}
