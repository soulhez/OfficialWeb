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
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			PrintWriter out=response.getWriter();
			if (method.equalsIgnoreCase("update")) {
				String content= request.getParameter("content");
				String id=new NvntitleTBDaoImpl().searchnNontent(content).getnId();
				String newContent=request.getParameter("newContent");
				if (new NvntitleTBDaoImpl().updateNvntitleTB(id, newContent)>0) {
					out.write(newContent);
				}else{
					out.write(content);
				}
			}else{
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
				JSONArray nvnTitleTBlist=new JSONArray().fromObject(list);
				out.write(nvnTitleTBlist.toString());
			}
	}
}
