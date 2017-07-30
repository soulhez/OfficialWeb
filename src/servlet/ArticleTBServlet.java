package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
			if (method==null) {
				System.out.println("null");
				return;
			}
			PrintWriter out=response.getWriter();
			int number=0;
			//�������
			if (method.equalsIgnoreCase("add")) {
				articleTB=new WebUtils().beanFrom(request, ArticleTB.class);
				ServletContext sc=request.getSession().getServletContext();
				 number=new ArticleTBDaoImpl().addArticleTB(sc.getRealPath("/")+"\\news\\",articleTB);
				if (number>0) {
					out.write("��ӳɹ�");
					return;
				}else{
					out.write("���ʧ��");
					return;
				}
			}//��������IDɾ������
			else if(method.equalsIgnoreCase("delete")){
				aId=request.getParameter("id");
				 number=new ArticleTBDaoImpl().deleteArticleTB(aId);
				if (number>0) {
					out.write("ɾ���ɹ�");
					return;
				}else{
					out.write("ɾ��ʧ��");
					return;
				}
			}//��������ID�޸�����
			else if(method.equalsIgnoreCase("update")){
				articleTB=new WebUtils().beanFrom(request, ArticleTB.class);
				number=new ArticleTBDaoImpl().updateArticleTB(articleTB);
				if (number>0) {
					out.write("��ӳɹ�");
					return;
				}else{
					out.write("���ʧ��");
					return;
				}
			}
	}
}
