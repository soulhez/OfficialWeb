package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.MaterialTBDao;
import entity.MaterialTB;

/**
 * 素材实现类
 * @author Administrator
 *
 */
public class MaterialTBDaoImpl extends BaseDao implements MaterialTBDao {
	/**
	 * 根据素材类型查询此类型的素材集合
	 */
	public List<MaterialTB> searchMaterialTB(String mType,String start,String end) {
		String sql=null;
		if(start==null || end==null||"".equals(start)||"".equals(end)){
			sql="select * from materialTB";
			rs=executeQuery(sql);
		}else 
		if(mType==null||"".equals(mType)){
			 sql="select * from materialTB limit ?,?";
			 rs=executeQuery(sql,Integer.parseInt(start),Integer.parseInt(end));
		}else{
			sql="select * from materialTB where type=? limit ?,?";
			rs=executeQuery(sql,mType,Integer.getInteger(start),Integer.getInteger(end));
		}
		List<MaterialTB> list=new ArrayList<MaterialTB>();
		MaterialTB mt=null;
		try {
			while(rs.next()){
				mt=new MaterialTB(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(mt);
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
	public MaterialTB searchMaterialTBmName(String mType) {
		String sql="select * from materialTB where type=?";
		rs=executeQuery(sql,mType);
		MaterialTB mt=null;
		try {
			while(rs.next()){
					mt=new MaterialTB(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return mt;
	}
	/**
	 * 根据素材名称模糊查询
	 */
	public List<MaterialTB> searchMaterialTBByName(String mName, String start,
			String end) {
		String sql=null;
		if(start==null || end==null||"".equals(start)||"".equals(end)){
			sql="select * from materialTB";
			rs=executeQuery(sql);
		}else 
		if(mName==null||"".equals(mName)){
			 sql="select * from materialTB limit ?,?";
			 rs=executeQuery(sql,Integer.parseInt(start),Integer.parseInt(end));
		}else{
			sql="select * from materialTB where name like ? limit ?,?";
			rs=executeQuery(sql,mName,Integer.getInteger(start),Integer.getInteger(end));
		}
		List<MaterialTB> list=new ArrayList<MaterialTB>();
		MaterialTB mt=null;
		try {
			while(rs.next()){
				mt=new MaterialTB(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(mt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	
}
