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
			int number=0;
			PrintWriter out=response.getWriter();
			//添加文章类型
			if(method.equalsIgnoreCase("add")){
				articleTypeTB=WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
				if(number>0){
					out.write("添加成功");
					return;
				}else{
					out.write("添加失败");
					return;
				}
				
			}//修改文章类型
			else if(method.equalsIgnoreCase("update")){
				articleTypeTB= WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB);
				if(number>0){
					out.write("修改成功");
					return;
				}else{
					out.write("修改失败");
					return;
				}
			}//删除文章类型
			else{
				 aId=request.getParameter("id");
				number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB(aId);
				if (number>0) {
					out.write("删除成功");
					return;
				}else{
					out.write("删除失败");
					return;
				}
			}
	}
}
