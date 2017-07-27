package test;

import util.WebUtils;
import bean.LoginBean;
import entity.AdminTB;

public class Test {
	public static void main(String[] args) {
		AdminTB admin=new AdminTB();
		LoginBean login=new LoginBean("love@und.win","admin8888");
		WebUtils.copyBean(admin, login);
		System.out.println(admin.getaEmail());
		System.out.println(admin.getaPwd());
	}
}
