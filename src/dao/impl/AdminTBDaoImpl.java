package dao.impl;

import java.sql.SQLException;

import bean.LoginBean;
import dao.AdminTBDao;
import dao.BaseDao;
import entity.AdminTB;

/**
 * ����Աʵ����
 * @author Administrator
 *
 */
public class AdminTBDaoImpl extends BaseDao implements AdminTBDao {
	/**
	 * ��¼
	 */
	public AdminTB login(AdminTB login) {
		AdminTB at=null;
		String sql="select * from adminTB where Email=? and pwd=?";
		rs=executeQuery(sql, login.getaEmail(),login.getaPwd());
		try {
			while(rs.next()){
				at=new AdminTB(rs.getString("id"),rs.getString("userName"),rs.getString("Email"),rs.getString("pwd"));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
	}

}
