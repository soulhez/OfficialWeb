package dao;

import bean.LoginBean;
import entity.AdminTB;

/**
 * ����Ա�ӿ�
 * @author Administrator
 *
 */
public interface AdminTBDao {
	  AdminTB login(LoginBean login);//��¼
	  int updateAdminTB(String aId,AdminTB adminTB);
}
