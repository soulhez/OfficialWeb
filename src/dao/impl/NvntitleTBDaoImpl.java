package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.NvntitleTBDao;
import entity.NvntitleTB;

/**
 * 导航实现类
 * @author Administrator
 *
 */
public class NvntitleTBDaoImpl extends BaseDao implements NvntitleTBDao {
	/**
	 * 查看所有导航
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
	 * 修改导航(通过获取的id和新的导航内容)
	 */
	public int updateNvntitleTB(String nId, String nNontent) {
		String sql="update nvntitleTB set content=? where id=?";
		return executeUpdate(sql,nNontent,nId);
	}
}
