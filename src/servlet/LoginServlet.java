package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.AdminTBDaoImpl;

import entity.AdminTB;

import util.WebUtils;

import bean.LoginBean;

/**
 * µÇÂ½servlet
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
			LoginBean bean=WebUtils.beanFrom(request, LoginBean.class);
			if (!bean.isLogin()) {
				response.sendRedirect("login.html");
			}
			AdminTB admin=new AdminTBDaoImpl().login(bean);
			if (admin==null) {
				response.sendRedirect("/back/HelloHBuilder/login.html");
			}else{
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("/back/HelloHBuilder/newsPages.html");
			}
	}
	
}
