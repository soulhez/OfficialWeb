package dao;

import bean.LoginBean;
import entity.AdminTB;

/**
 * 管理员接口
 * @author Administrator
 *
 */
public interface AdminTBDao {
	  AdminTB login(AdminTB login);//登录
	  int updateAdminTB(String aId,AdminTB adminTB);
}
