package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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
			//ɾ����������
			if(method==null||"".equals(method)){
				 aId=request.getParameter("id");
					number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB(aId);
					out.write(number>0?"ɾ���ɹ�":"ɾ��ʧ��");
					return;
			}else
			//�����������
			if(method.equalsIgnoreCase("add")){
				articleTypeTB=WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
				out.write(number>0?"��ӳɹ�":"���ʧ��");
				 return;
			}//�޸���������
			else if(method.equalsIgnoreCase("update")){
				articleTypeTB= WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB);
				out.write(number>0?"�޸ĳɹ�":"�޸�ʧ��");
				return;
			}else{
				String name=request.getParameter("name");
				if(name!=null||!"".equals(name)){
					 List<ArticleTypeTB> list=new ArticleTypeTBDaoImpl().searchArticleTypeTBByName(name);
					 JSONArray ja=JSONArray.fromObject(list);
					 out.write(ja.toString());
					 return;
				}
			}
	}
}
