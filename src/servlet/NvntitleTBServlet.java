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
			if(method==null||"".equals(method)){
				//显示所有导航
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				out.write(nvnTitleTBlist.toString());
				return;
			}else if(method.equalsIgnoreCase("update")) {
				String id= request.getParameter("id");
				String newContent=request.getParameter("newContent");
				//通过获取的id和新的导航内容修改导航内容
				out.write(new NvntitleTBDaoImpl().updateNvntitleTB(id, newContent)>0?"修改成功":"修改失败");
				return;
			}else if(method.equalsIgnoreCase("selectNvntitle")){
				//根据导航内容模糊查询
				String newContent=request.getParameter("newContent");
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTBByContent(newContent);
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				out.write(nvnTitleTBlist.toString());
				System.out.print(nvnTitleTBlist.toString());
				return;
			}
	}
}
