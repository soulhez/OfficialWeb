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
	  int updateAdminTB(AdminTB adminTB);//�޸Ĺ���Ա�˺���Ϣ
}
