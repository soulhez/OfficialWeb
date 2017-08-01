package dao;

import bean.LoginBean;
import entity.AdminTB;

/**
 * 管理员接口
 * @author Administrator
 *
 */
public interface AdminTBDao {
	  AdminTB login(LoginBean login);//登录
	  int updateAdminTB(AdminTB adminTB);//修改管理员账号信息
}
