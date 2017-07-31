package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import dao.impl.MaterialTBDaoImpl;

public class MaterrialTBServlet extends HttpServlet {

	/**
	 * �ز�servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			PrintWriter out=response.getWriter();
			String mType=request.getParameter("mType");
			//�����ز����Ͳ�ѯ�����͵��زļ���
			if(method==null){
				List<String> list=new MaterialTBDaoImpl().searchMaterialTB(mType);
				JSONArray ja=JSONArray.fromObject(list);
				out.write(ja.toString());
				return;				
			}else
				//�����ز����Ͳ�ѯһ���زĵ�����
			if(method.equalsIgnoreCase("name")){
				String name=new MaterialTBDaoImpl().searchMaterialTBmName(mType);
				out.write(name);
				return;
			}
	}
}
