package test;

import util.WebUtils;
import bean.TestLoginBean;
import entity.AdminTB;

public class Test {
	public static void main(String[] args) {
		AdminTB admin=new AdminTB();
		TestLoginBean login=new TestLoginBean("love@und.win","admin8888");
		WebUtils.copyBean(admin, login);
		System.out.println(admin.getaEmail());
		System.out.println(admin.getaPwd());
	}
}
