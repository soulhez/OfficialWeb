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
			if(method==null){
				//��ʾ���е���
				List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
				JSONArray nvnTitleTBlist=JSONArray.fromObject(list);
				System.out.print(nvnTitleTBlist.toString());
				out.write(nvnTitleTBlist.toString());
			}else if(method.equalsIgnoreCase("update")) {
				String content= request.getParameter("content");
				//���ݵ������ݻ�ȡ����id
				String id=new NvntitleTBDaoImpl().searchnNontent(content).getnId();
				String newContent=request.getParameter("newContent");
				//ͨ����ȡ��id���µĵ��������޸ĵ�������
				if (new NvntitleTBDaoImpl().updateNvntitleTB(id, newContent)>0) {
					out.write(newContent);
				}else{
					out.write(content);
				}
			}
	}
}
