package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import dao.impl.ArticleTBDaoImpl;
import dao.impl.ArticleTypeTBDaoImpl;

import entity.AdminTB;
import entity.ArticleTB;
import entity.ArticleTypeTB;

public class IDServlet extends HttpServlet {
	

	/**
	 * 获取ID的servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=null;
			method=request.getParameter("method");
			String id=null;
			id=(String)request.getAttribute("id");
			String start=null;
			start=request.getParameter("start");
			String end=null;
			end=request.getParameter("end");
			
			//根据文章类型ID查询文章后，以文章创建时间降序排列
			PrintWriter out=response.getWriter();
			 if(method.equalsIgnoreCase("searchArticleTB")){
				 List<ArticleTB> list=new ArticleTBDaoImpl().searchArticleTB(id, start, end);
				 JSONArray ja=JSONArray.fromObject(list);
				 out.write(ja.toString());
				 return;
			}//根据文章ID查询文章
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				ArticleTB at=new  ArticleTBDaoImpl().searchArticleTBByID(id,WebUtils.getPath(request));
				JSONObject json=JSONObject.fromObject(at);
				out.write(json.toString());
				return;
			}
			 //根据导航ID查询文章类型集合
			else if(method.equalsIgnoreCase("searchArticleTypeTB")){
				 List<ArticleTypeTB> list=new ArticleTypeTBDaoImpl().searchArticleTypeTB(id);
				 JSONArray ja=JSONArray.fromObject(list);
				 out.write(ja.toString());
				 return;
			}
			 //获取管理员信息
			else{
				AdminTB admin=(AdminTB)request.getSession().getAttribute("admin");
				JSONObject json=JSONObject.fromObject(admin);
				out.write(json.toString());
				return;
			}
	}
}
