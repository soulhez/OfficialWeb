package dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.MaterialTBDao;
import entity.MaterialTB;

/**
 * �ز�ʵ����
 * @author Administrator
 *
 */
public class MaterialTBDaoImpl extends BaseDao implements MaterialTBDao {
	/**
	 * �����ز����ͺ��������Ʋ�ѯ�����͵��زļ���
	 */
	public List<MaterialTB> searchMaterialTB(String mType,String mName,String start,String end) {
		String sql=null;
		if(start==null || end==null||"".equals(start)||"".equals(end)){
			if(mType==null||"".equals(mType)){
				if(mName==null||"".equals(mName)){
					sql="select * from materialTB";
					 rs=executeQuery(sql);	
				}else{
					sql="select * from materialTB where name like ?";
					rs=executeQuery(sql,mName);
				}
				 
			}else{
				if(mName==null||"".equals(mName)){
					sql="select * from materialTB where type=?";
					rs=executeQuery(sql,mType);	
				}else{
					sql="select * from materialTB where type=? and name like ?";
					rs=executeQuery(sql,mType,mName);
				}
				
			}
		}else{
			if(mType==null||"".equals(mType)){
				if(mName==null||"".equals(mName)){
					sql="select * from materialTB limit ?,?";
					 rs=executeQuery(sql,Integer.parseInt(start),Integer.parseInt(end));	
				}else{
					sql="select * from materialTB where name like ? limit ?,?";
					rs=executeQuery(sql,mName,Integer.parseInt(start),Integer.parseInt(end));
				}
				 
			}else{
				if(mName==null||"".equals(mName)){
					sql="select * from materialTB where type=? limit ?,?";
					rs=executeQuery(sql,mType,Integer.parseInt(start),Integer.parseInt(end));	
				}else{
					sql="select * from materialTB where type=? and name like ? limit ?,?";
					rs=executeQuery(sql,mType,mName,Integer.parseInt(start),Integer.parseInt(end));
				}
				
			}
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
	 * �����ز����Ͳ�ѯ�ز�����
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
	 * ��ѯ�����ز����ͷ����ز����ͼ���
	 */
	public List<String> searchMaterialTBType() {
		List<String> list=new ArrayList<String>();
		String sql="select distinct type from materialTB ";
		rs=executeQuery(sql);
		try {
			while(rs.next()){
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
}
