package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.AdminTBDaoImpl;

import entity.AdminTB;

import util.WebUtils;

import bean.LoginBean;

/**
 * ��½servlet
 * @author 22386
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			LoginBean bean=WebUtils.beanFrom(request, LoginBean.class);
			if (!bean.isLogin()) {
				out.write("�û����������벻��Ϊ��!");
				return;
			}
			AdminTB admin=new AdminTBDaoImpl().login(bean);
			if (admin==null||"".equals(admin)) {
				out.write("�˻������������!");
				return;
			}else{
				request.getSession().setAttribute("admin", admin);
				out.write("��¼�ɹ���");
				return;
			}
	}
	
}
