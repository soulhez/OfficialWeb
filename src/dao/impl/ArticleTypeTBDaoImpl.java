package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTypeTBDao;
import dao.BaseDao;
import entity.ArticleTB;
import entity.ArticleTypeTB;

/**
 * ��������ʵ����
 * @author Administrator
 *
 */
public class ArticleTypeTBDaoImpl extends BaseDao implements ArticleTypeTBDao {
	/**
	 * �����������
	 */
	public int addArticleTypeTB(ArticleTypeTB articleTypeTB) {
		String sql="insert into articletypeTB(name,nvntitleTBid) value(?,?)";
		return executeUpdate(sql,articleTypeTB.getaName(),articleTypeTB.getaNvntitleTBid());
	}
	/**
	 * ɾ����������
	 */
	public int deleteArticleTypeTB(String aId) {
		String sql="delete from articletypeTB where id=?";
		return executeUpdate(sql,aId);
	}
	/**
	 * ����������������id��ѯ������������
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
	 * ��������id��ѯ��������
	 */
	public ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID) {
		ArticleTypeTB at=null;
		String sql="select * from articletypeTB where id=?";
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
	 * �޸���������
	 */
	public int updateArticleTypeTB(String aId, ArticleTypeTB articleTypeTB) {
		String sql="update articleTB set name=?,nvntitleTBid=? where id=?";
		return executeUpdate(sql,articleTypeTB.getaName(),articleTypeTB.getaNvntitleTBid(),articleTypeTB.getaId());
	}
	

}
