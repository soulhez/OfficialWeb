package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.WebUtils;

import dao.ArticleTBDao;
import dao.BaseDao;
import entity.ArticleTB;
import entity.ArticleTypeTB;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class ArticleTBDaoImpl extends BaseDao implements ArticleTBDao {
	/**
	 * �������
	 */
	public int addArticleTB(String path,ArticleTB articleTB) {
		int num =WebUtils.newFile(path, articleTB.getaArticleTitle(),articleTB.getaArticlePath());
		if (num>0) {
			articleTB.setaArticlePath(path+articleTB.getaArticleTitle()+".txt");
		}else{
			return 0;
		}
		String sql="insert into articleTB(articletitle,articlepath,articletypetbID) value(?,?,?)";
		return executeUpdate(sql, articleTB.getaArticleTitle(),articleTB.getaArticlePath(),articleTB.getaArticleTypetbID());
	}
	/**
	 * ��������ID�޸�����
	 */
	public int updateArticleTB(ArticleTB articleTB) {
		String sql="update articleTB set articletitle=?,articlecontent=?,newDate=?,articletypetbID=? where id=?";
		return executeUpdate(sql,articleTB.getaArticleTitle(),articleTB.getaArticlePath(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID(),articleTB.getaId());
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
		String sql="select * from ArticleTB where articletypetbID=? order by newDate desc limit ?,?";
		rs=executeQuery(sql,aArticleTypetbID,Integer.parseInt(start),Integer.parseInt(end));
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
		String sql="select * from articleTB where id=?";
		rs=executeQuery(sql,aId);
		try {
			while(rs.next()){
				at=new ArticleTB(rs.getString("id"),rs.getString("articletitle"),rs.getString("articlepath"),rs.getString("newDate"),rs.getString("articletypetbID"));
				at.setaArticlePath(WebUtils.readFile(at.getaArticlePath()));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
	}
	
	/**
	 * ��������id��ѯ��������
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

}
