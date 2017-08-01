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
			//删除文章类型
			if(method==null||"".equals(method)){
				 aId=request.getParameter("id");
					number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB(aId);
					out.write(number>0?"删除成功":"删除失败");
					return;
			}else
			//添加文章类型
			if(method.equalsIgnoreCase("add")){
				articleTypeTB=WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
				out.write(number>0?"添加成功":"添加失败");
				 return;
			}//修改文章类型
			else if(method.equalsIgnoreCase("update")){
				articleTypeTB= WebUtils.beanFrom(request, ArticleTypeTB.class);
				number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB);
				out.write(number>0?"修改成功":"修改失败");
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
