package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IDServlet extends HttpServlet {
	

	/**
	 * ��ȡID��servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			//������������ID��ѯ���º������´���ʱ�併������
			 if(method.equalsIgnoreCase("searchArticleTB")){
				
			}//��������ID��ѯ����
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				
			}
			 //���ݵ���ID��ѯ�������ͼ���
			else if(method.equalsIgnoreCase("searchArticleTypeTB")){
				
			}
			 //��ȡ����Ա��Ϣ
			else{
				
			}
	}
}
