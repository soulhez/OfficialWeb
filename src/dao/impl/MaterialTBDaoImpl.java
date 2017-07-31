package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.MaterialTBDao;

/**
 * 素材实现类
 * @author Administrator
 *
 */
public class MaterialTBDaoImpl extends BaseDao implements MaterialTBDao {
	/**
	 * 根据素材类型查询此类型的素材集合
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
	 * 根据素材类型查询素材名称
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
