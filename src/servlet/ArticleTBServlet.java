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
			String aArticleTypetbID=null;//文章类型id
			String method =request.getParameter("method");
			PrintWriter out=response.getWriter();
			//添加文章
			if (method.equalsIgnoreCase("add")) {
				articleTB=new WebUtils().beanFrom(request, ArticleTB.class);
				int number=new ArticleTBDaoImpl().addArticleTB(articleTB);
				if (number>0) {
					out.write("添加成功");
					return;
				}else{
					out.write("添加失败");
					return;
				}
			}//根据文章ID删除文章
			else if(method.equalsIgnoreCase("delete")){
				
			}//根据文章ID修改文章
			else if(method.equalsIgnoreCase("update")){
				
			}//根据文章类型ID查询文章后，以文章创建时间降序排列
			else if(method.equalsIgnoreCase("searchArticleTB")){
				
			}//根据文章ID查询文章
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				
			}//根据文章id查询文章类型
			else{
				
			}
	}
}
