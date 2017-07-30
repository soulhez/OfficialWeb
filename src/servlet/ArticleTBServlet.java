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
	 * 文章servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			ArticleTB articleTB=null;//文章对象
			String aId=null;//文章id
			String method =request.getParameter("method");
			if (method==null) {
				System.out.println("null");
				return;
			}
			PrintWriter out=response.getWriter();
			int number=0;
			//添加文章
			if (method.equalsIgnoreCase("add")) {
				articleTB=WebUtils.beanFrom(request, ArticleTB.class);
				 number=new ArticleTBDaoImpl().addArticleTB(WebUtils.getPath(request),articleTB);
				if (number>0) {
					out.write("添加成功");
					return;
				}else{
					out.write("添加失败");
					return;
				}
			}//根据文章ID删除文章
			else if(method.equalsIgnoreCase("delete")){
				aId=request.getParameter("id");
				 number=new ArticleTBDaoImpl().deleteArticleTB(aId,WebUtils.getPath(request));
				if (number>0) {
					out.write("删除成功");
					return;
				}else{
					out.write("删除失败");
					return;
				}
			}//根据文章ID修改文章
			else if(method.equalsIgnoreCase("update")){
				articleTB=WebUtils.beanFrom(request, ArticleTB.class);
				number=new ArticleTBDaoImpl().updateArticleTB(articleTB,WebUtils.getPath(request));
				if (number>0) {
					out.write("修改成功");
					return;
				}else{
					out.write("修改失败");
					return;
				}
			}
	}
}
