package dao.impl;

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
		return 0;
	}
	/**
	 * 删除文章类型
	 */
	public int deleteArticleTypeTB(String aId) {
		return 0;
	}
	/**
	 * 根据所属导航标题id查询所有文章类型
	 */
	public List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid) {
		return null;
	}
	/**
	 * 根据文章id查询文章类型
	 */
	public ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID) {
		return null;
	}
	/**
	 * 修改文章类型
	 */
	public int updateArticleTypeTB(String aId, ArticleTypeTB articleTypeTB) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
