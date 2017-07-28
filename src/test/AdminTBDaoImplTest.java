package test;

import bean.LoginBean;
import dao.impl.AdminTBDaoImpl;
import entity.AdminTB;

/**
 * 管理员功能测试
 * @author 22386
 *
 */
public class AdminTBDaoImplTest {
	public static void main(String[] args) {
		String aEmail="zhangsan@admin.com";
		String aPwd="admin";
		LoginBean login=new LoginBean();
		login.setaEmail(aEmail);
		login.setaPwd(aPwd);
		AdminTB adminTB=new AdminTBDaoImpl().login(login);
		System.out.println(adminTB.getaUserName()+adminTB.getaEmail()+adminTB.getaPwd()+adminTB.getaID());
		int number=new AdminTBDaoImpl().updateAdminTB(adminTB.getaID(), adminTB);
		System.out.println(number);
	}
}
