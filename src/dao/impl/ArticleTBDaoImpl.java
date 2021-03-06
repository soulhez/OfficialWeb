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
 * 文章实现类
 * @author Administrator
 *
 */
public class ArticleTBDaoImpl extends BaseDao implements ArticleTBDao {
	/**
	 * 添加文章
	 */
	public int addArticleTB(String path,ArticleTB articleTB) {
		int num =WebUtils.newFile(path, articleTB.getaArticleTitle(),articleTB.getaContent());
		String sql="insert into articleTB(articletitle,articletypetbID) value(?,?)";
		return num<=0?0:executeUpdate(sql, articleTB.getaArticleTitle(),articleTB.getaArticleTypetbID());
	}
	/**
	 * 根据文章ID修改文章
	 */
	public int updateArticleTB(ArticleTB articleTB,String path) {
		String titleString=getTitleById(articleTB.getaId());
		int num=0;

		String sql="update articleTB set articletitle=?,newDate=?,articletypetbID=? where id=?";
		if (!articleTB.getaArticleTitle().equalsIgnoreCase(titleString)) {
			if(!WebUtils.deleteFile(path, titleString)){
				num=0;
			}
		}
		if(articleTB.getaContent()!=null||!"".equals(articleTB.getaContent())){
			num =WebUtils.newFile(path, articleTB.getaArticleTitle(),articleTB.getaContent());			
		}
		return num<=0?0:executeUpdate(sql,articleTB.getaArticleTitle(),articleTB.getaNewDate(),articleTB.getaArticleTypetbID(),articleTB.getaId());
	}
	/**
	 * 根据文章ID删除文章
	 */
	public int deleteArticleTB(String aId,String path) {
		String sql="delete from articleTB where id=?";
		String titleString=getTitleById(aId);
		return WebUtils.deleteFile(path,titleString)?executeUpdate(sql,aId):0;
	}
	/**
	 * 根据文章类型ID和文章标题模糊查询文章后，以文章创建时间降序排列
	 * aArticleTypetbID文章类型id
	 * aArticleTitle文章标题
	 */
	public List<ArticleTB> searchArticleTB(String aArticleTypetbID,String aArticleTitle,String start,String end) {
		String sql=null;
		if(start==null||"".equals(start)||end==null||"".equals(end)){
			if(aArticleTypetbID==null||"".equals(aArticleTypetbID)){
				if(aArticleTitle==null||"".equals(aArticleTitle)){
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on  at.articletypetbID=ty.id order by newDate desc";
					rs=executeQuery(sql);
				}else{
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletitle like ?";
					rs=executeQuery(sql,"%"+aArticleTitle+"%");
				}
			}else{
				if(aArticleTitle==null||"".equals(aArticleTitle)){
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletypetbID=?  order by newDate desc";
					rs=executeQuery(sql,aArticleTypetbID);
				}else{
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletypetbID=? and articletitle like ? order by newDate desc";
					rs=executeQuery(sql,aArticleTypetbID,"%"+aArticleTitle+"%");
				}
				
			}
		}else{
			if(aArticleTypetbID==null||"".equals(aArticleTypetbID)){
				if(aArticleTitle==null||"".equals(aArticleTitle)){
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on  at.articletypetbID=ty.id order by newDate desc limit ?,?";
					rs=executeQuery(sql,Integer.parseInt(start),Integer.parseInt(end));
				}else{
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletitle like ? limit ?,?";
					rs=executeQuery(sql,"%"+aArticleTitle+"%",Integer.parseInt(start),Integer.parseInt(end));
				}
			}else{
				if(aArticleTitle==null||"".equals(aArticleTitle)){
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletypetbID=?  order by newDate desc limit ?,?";
					rs=executeQuery(sql,aArticleTypetbID,Integer.parseInt(start),Integer.parseInt(end));
				}else{
					sql="select at.id,at.articletitle,newDate,ty.id,ty.name from ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.articletypetbID=? and articletitle like ? order by newDate desc limit ?,?";
					rs=executeQuery(sql,aArticleTypetbID,"%"+aArticleTitle+"%",Integer.parseInt(start),Integer.parseInt(end));
				}
				
			}
		}
		List<ArticleTB> list=new ArrayList<ArticleTB>();
		ArticleTB at=null;
		try {
			while(rs.next()){
				at=new ArticleTB();
				at.setaId(rs.getString(1));
				at.setaArticleTitle(rs.getString(2));
				at.setaNewDate(rs.getString(3));
				at.setaArticleTypetbID(rs.getString(4));
				at.setaArticleTypetbName(rs.getString(5));
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
	public ArticleTB searchArticleTBByID(String aId,String path) {
		ArticleTB at=null;
		String sql="select at.id,at.articletitle,at.newDate,ty.id,ty.name from  ArticleTB at inner join articletypetb ty on at.articletypetbID=ty.id where at.id=?";
		rs=executeQuery(sql,aId);
		try {
			while(rs.next()){
				at=new ArticleTB();
				at.setaId(rs.getString(1));
				at.setaArticleTitle(rs.getString(2));
				at.setaNewDate(rs.getString(3));
				at.setaArticleTypetbID(rs.getString(4));
				at.setaArticleTypetbName(rs.getString(5));
				at.setaContent(WebUtils.readFile(path,at.getaArticleTitle()));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return at;
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
	 * 返回文章标题
	 */
	public String getTitleById(String id) {
		String titleString=null;
		String sql="select articletitle from articleTB where id=?";
		rs=executeQuery(sql,id);
		try {
			while(rs.next()){
				titleString=rs.getString("articletitle");
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			closeAll();
		}
		return titleString;
	}
}
