package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.AdminTBDaoImpl;

import util.WebUtils;

import entity.AdminTB;

public class AdminServlet extends HttpServlet {

	/**
	 * 管理员servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			AdminTB atAdminTB=WebUtils.beanFrom(request, AdminTB.class);
			AdminTB atAdminTB2=(AdminTB)request.getSession().getAttribute("admin");
			atAdminTB.setaID(atAdminTB2.getaID());
			int number=new AdminTBDaoImpl().updateAdminTB(atAdminTB);
			PrintWriter out=response.getWriter();
			out.write(number>0?"修改成功":"修改失败");
			return;
	}
}
