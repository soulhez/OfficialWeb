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
	 * ����servlet
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
				//��ʾ���е���
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				out.write(nvnTitleTBlist.toString());
				return;
			}else if(method.equalsIgnoreCase("update")) {
				String id= request.getParameter("id");
				String newContent=request.getParameter("newContent");
				//ͨ����ȡ��id���µĵ��������޸ĵ�������
				if (new NvntitleTBDaoImpl().updateNvntitleTB(id, newContent)>0) {
					out.write(newContent);
				}
				return;
			}else{
				//���ݵ�������ģ����ѯ
				String content=request.getParameter("content");
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTBByContent(content);
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				out.write(nvnTitleTBlist.toString());
				return;
			}
	}
}
