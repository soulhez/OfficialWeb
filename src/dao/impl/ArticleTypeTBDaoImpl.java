package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTypeTBDao;
import dao.BaseDao;
import entity.ArticleTB;
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
	 * 根据所属导航标题id查询所有文章类型
	 */
	public List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid) {
		List<ArticleTypeTB> list=new ArrayList<ArticleTypeTB>();
		ArticleTypeTB at=null;
		String sql="select * from articletypeTB where nvntitleTBid=?";
		rs=executeQuery(sql,aNvntitleTBid);
		try {
			while(rs.next()){
				at=new ArticleTypeTB(rs.getString("id"),rs.getString("name"),rs.getString("nvntitleTBid"));
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
	 * 根据文章id查询文章类型
	 */
	public ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID) {
		ArticleTypeTB at=null;
		String sql="select * from articletypeTB t inner join articleTB a on a.articletypetbID=t.id where a.id=?";
		rs=executeQuery(sql,aID);
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
	/**
	 * 修改文章类型
	 */
	public int updateArticleTypeTB(String aId, ArticleTypeTB articleTypeTB) {
		String sql="update articletypeTB set name=?,nvntitleTBid=? where id=?";
		return executeUpdate(sql,articleTypeTB.getaName(),articleTypeTB.getaNvntitleTBid(),articleTypeTB.getaId());
	}
	

}
