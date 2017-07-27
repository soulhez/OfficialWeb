package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTBDao;
import dao.BaseDao;
import entity.AdminTB;
import entity.ArticleTB;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class ArticleTBDaoImpl extends BaseDao implements ArticleTBDao {
	/**
	 * �������
	 */
	public int addArticleTB(ArticleTB articleTB) {
		String sql="insert into articleTB(articletitle,articlecontent,newDate,articletypetbID) value(?,?,?,?)";
		return executeUpdate(sql, articleTB.getaArticleTitle(),articleTB.getaArticlecontent(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID());
	}
	/**
	 * ��������IDɾ������
	 */
	public int deleteArticleTB(String aId) {
		String sql="delete from articleTB where id=?";
		return executeUpdate(sql,aId);
	}
	/**
	 * ������������ID��ѯ���º������´���ʱ�併������
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
	 * ��������ID��ѯ����
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
	 * ��������ID�޸�����
	 */
	public int updateArticleTB(String aId, ArticleTB articleTB) {
		String sql="update articleTB set articletitle=?,articlecontent=?,newDate=?,articletypetbID=? where id=?";
		return executeUpdate(sql,aId,articleTB.getaArticleTitle(),articleTB.getaArticlecontent(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID(),articleTB.getaId());
	}

}
