package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import dao.impl.MaterialTBDaoImpl;
import entity.MaterialTB;

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
			String mType=request.getParameter("mType");//�ز�����
			String start =request.getParameter("start");
			String end =request.getParameter("end");
			String mName=request.getParameter("name");//�ز�����
			//�����ز����Ͳ�ѯ�����͵��زļ���
			if(method==null||"".equals(method)){
				List<MaterialTB> list=new MaterialTBDaoImpl().searchMaterialTB(mType,mName,start,end);
				JSONArray ja=JSONArray.fromObject(list);
				out.write(ja.toString());
				return;				
			}else
				//�����ز����Ͳ�ѯһ���زĵ�����
			if(method.equalsIgnoreCase("name")){
				MaterialTB name=new MaterialTBDaoImpl().searchMaterialTBmName(mType);
				JSONObject json=JSONObject.fromObject(name);
				out.write(json.toString());
				return;
			}
	}
}
