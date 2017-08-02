package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTypeTBDao;
import dao.BaseDao;
import entity.ArticleTypeTB;

/**
 * 文章类型实现类
 * @author Administrator
 *
 */
public class ArticleTypeTBDaoImpl extends BaseDao implements ArticleTypeTBDao {
	/**
	 * 添加文章类型
	 */
	public int addArticleTypeTB(ArticleTypeTB articleTypeTB) {
		String sql="insert into articletypeTB(name,nvntitleTBid) value(?,?)";
		return executeUpdate(sql,articleTypeTB.getaName(),articleTypeTB.getaNvntitleTBid());
	}
	/**
	 * 删除文章类型
	 */
	public int deleteArticleTypeTB(String aId) {
		String sql="delete from articletypeTB where id=?";
		return executeUpdate(sql,aId);
	}
	/**
	 * 根据所属导航标题id,和文章类型名称模糊查询所有文章类型
	 */
	public List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid,String aNvntitleTBName) {
		List<ArticleTypeTB> list=new ArrayList<ArticleTypeTB>();
		ArticleTypeTB at=null;
		String sql=null;
		if(aNvntitleTBid==null||"".equals(aNvntitleTBid)){
			if(aNvntitleTBName==null||"".equals(aNvntitleTBName)){
				sql="select ty.id,ty.name,ty.nvntitleTBid,n.content from articletypeTB ty inner join nvntitleTB n on n.id=ty.nvntitleTBid";
				rs=executeQuery(sql);
			}else{
				sql="select ty.id,ty.name,ty.nvntitleTBid,n.content from articletypeTB ty inner join nvntitleTB n on n.id=ty.nvntitleTBid where ty.name like ?";
				rs=executeQuery(sql,"%"+aNvntitleTBName+"%");
			}
		}else{
			if(aNvntitleTBName==null||"".equals(aNvntitleTBName)){
				sql="select ty.id,ty.name,ty.nvntitleTBid,n.content from articletypeTB ty inner join nvntitleTB n on n.id=ty.nvntitleTBid where nvntitleTBid=?";
				rs=executeQuery(sql,aNvntitleTBid);
			}else{
				sql="select ty.id,ty.name,ty.nvntitleTBid,n.content from articletypeTB ty inner join nvntitleTB n on n.id=ty.nvntitleTBid where nvntitleTBid=? and ty.name like ?";
				rs=executeQuery(sql,aNvntitleTBid,"%"+aNvntitleTBName+"%");
			}
			
		}
		try {
			while(rs.next()){
				at=new ArticleTypeTB(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(at);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return list;
	}
	/**
	 * 修改文章类型
	 */
	public int updateArticleTypeTB(ArticleTypeTB articleTypeTB) {
		String sql="update articletypeTB set name=?,nvntitleTBid=? where id=?";
		return executeUpdate(sql,articleTypeTB.getaName(),articleTypeTB.getaNvntitleTBid(),articleTypeTB.getaId());
	}
	public ArticleTypeTB searchArticleTypeTBByArticleTypeTBName(String id) {
		ArticleTypeTB at=null;
		String sql="select * from articletypeTB where id=?";
		rs=executeQuery(sql,id);
		try {
			while(rs.next()){
				at=new ArticleTypeTB(rs.getString("id"),rs.getString("name"),rs.getString("nvntitleTBid"));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
	}
}
