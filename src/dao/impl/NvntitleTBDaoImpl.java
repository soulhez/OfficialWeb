package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.NvntitleTBDao;
import entity.NvntitleTB;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class NvntitleTBDaoImpl extends BaseDao implements NvntitleTBDao {
	/**
	 * �鿴���е���
	 */
	public List<NvntitleTB> searchNvntitleTB() {
		String sql="select *from nvntitleTB";
		rs=executeQuery(sql);
		List<NvntitleTB> list=new ArrayList<NvntitleTB>();
		NvntitleTB nvntitleTB=null;
		try {
			while(rs.next()){
				nvntitleTB=new NvntitleTB(rs.getString("id"),rs.getString("content"));
				list.add(nvntitleTB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	/**
	 * �޸ĵ���(ͨ����ȡ��id���µĵ�������)
	 */
	public int updateNvntitleTB(String nId, String nNontent) {
		String sql="update nvntitleTB set content=? where id=?";
		return executeUpdate(sql,nNontent,nId);
	}
}
