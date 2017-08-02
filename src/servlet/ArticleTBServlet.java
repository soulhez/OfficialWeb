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
			String method =request.getParameter("method");
			PrintWriter out=response.getWriter();
			int number=0;
			if(method==null||"".equals(method)){
				//�������
				articleTB=WebUtils.beanFrom(request, ArticleTB.class);
				 number=new ArticleTBDaoImpl().addArticleTB(WebUtils.getPath(request),articleTB);
				 out.write(number>0?"��ӳɹ�":"���ʧ��");
				 return;
			}//��������IDɾ������
			else if(method.equalsIgnoreCase("delete")){
				aId=request.getParameter("id");
				 number=new ArticleTBDaoImpl().deleteArticleTB(aId,WebUtils.getPath(request));
				 out.write(number>0?"ɾ���ɹ�":"ɾ��ʧ��");
				 return;
			}//��������ID�޸�����
			else if(method.equalsIgnoreCase("update")){
				articleTB=WebUtils.beanFrom(request, ArticleTB.class);
				number=new ArticleTBDaoImpl().updateArticleTB(articleTB,WebUtils.getPath(request));
				out.write(number>0?"�޸ĳɹ�":"�޸�ʧ��");
				return;
			}
	}
}
