package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.MaterialTBDao;

/**
 * �ز�ʵ����
 * @author Administrator
 *
 */
public class MaterialTBDaoImpl extends BaseDao implements MaterialTBDao {
	/**
	 * �����ز����Ͳ�ѯ�����͵��زļ���
	 */
	public List<String> searchMaterialTB(String mType) {
		String sql=null;
		if(mType==null){
			 sql="select * from materialTB";	
		}else{
			sql="select * from materialTB where type=?";
		}
		rs=executeQuery(sql,mType);
		List<String> list=new ArrayList<String>();
		try {
			while(rs.next()){
				list.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
		
	}
	/**
	 * �����ز����Ͳ�ѯ�ز�����
	 */
	public String searchMaterialTBmName(String mType) {
		String sql="select * from materialTB where type=?";
		rs=executeQuery(sql,mType);
		String name=null;
		try {
			while(rs.next()){
				name=rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return name;
	}
	
}
