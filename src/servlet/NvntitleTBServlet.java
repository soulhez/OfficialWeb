package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
 
import dao.impl.NvntitleTBDaoImpl;

import entity.NvntitleTB;

public class NvntitleTBServlet extends HttpServlet {
	/**
	 * 导航servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			PrintWriter out=response.getWriter();
			if(method==null){
				//显示所有导航
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				System.out.print(nvnTitleTBlist.toString());
				out.write(nvnTitleTBlist.toString());
			}else if(method.equalsIgnoreCase("update")) {
				String content= request.getParameter("content");
				//根据导航内容获取导航id
				String id=new NvntitleTBDaoImpl().searchnNontent(content).getnId();
				String newContent=request.getParameter("newContent");
				//通过获取的id和新的导航内容修改导航内容
				if (new NvntitleTBDaoImpl().updateNvntitleTB(id, newContent)>0) {
					out.write(newContent);
				}else{
					out.write(content);
				}
			}
	}
}
