package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTBDao;
import dao.BaseDao;
import entity.AdminTB;
import entity.ArticleTB;

/**
 * 文章实现类
 * @author Administrator
 *
 */
public class ArticleTBDaoImpl extends BaseDao implements ArticleTBDao {
	/**
	 * 添加文章
	 */
	public int addArticleTB(ArticleTB articleTB) {
		String sql="insert into articleTB(articletitle,articlecontent,newDate,articletypetbID) value(?,?,?,?)";
		return executeUpdate(sql, articleTB.getaArticleTitle(),articleTB.getaArticlecontent(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID());
	}
	/**
	 * 根据文章ID删除文章
	 */
	public int deleteArticleTB(String aId) {
		String sql="delete from articleTB where id=?";
		return executeUpdate(sql,aId);
	}
	/**
	 * 根据文章类型ID查询文章后，以文章创建时间降序排列
	 */
	public List<ArticleTB> searchArticleTB(String aArticleTypetbID, String start,String end) {
		List<ArticleTB> list=new ArrayList<ArticleTB>();
		ArticleTB at=null;
		String sql="select * from ArticleTB where aArticleTypetbID=? order by newDate desc limit ?,?";
		rs=executeQuery(sql,aArticleTypetbID,start,end);
		try {
			while(rs.next()){
				at=new ArticleTB(rs.getString("id"),rs.getString("articletitle"),rs.getString("articlecontent"),rs.getString("newDate"),rs.getString("articletypetbID"));
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
	 * 根据文章ID查询文章
	 */
	public ArticleTB searchArticleTBByID(String aId) {
		ArticleTB at=null;
		String sql="select * from ArticleTB where id=?";
		rs=executeQuery(sql,aId);
		try {
			while(rs.next()){
				at=new ArticleTB(rs.getString("id"),rs.getString("articletitle"),rs.getString("articlecontent"),rs.getString("newDate"),rs.getString("articletypetbID"));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
	}
	/**
	 * 根据文章ID修改文章
	 */
	public int updateArticleTB(String aId, ArticleTB articleTB) {
		String sql="update articleTB set articletitle=?,articlecontent=?,newDate=?,articletypetbID=? where id=?";
		return executeUpdate(sql,aId,articleTB.getaArticleTitle(),articleTB.getaArticlecontent(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID(),articleTB.getaId());
	}

}
