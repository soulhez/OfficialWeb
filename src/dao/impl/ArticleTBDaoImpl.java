package dao.impl;

import java.util.List;

import dao.ArticleTBDao;
import dao.BaseDao;
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
		return 0;
	}
	/**
	 * 根据文章ID删除文章
	 */
	public int deleteArticleTB(String aId) {
		return 0;
	}
	/**
	 * 根据文章类型ID查询文章后，以文章创建时间降序排列
	 */
	public List<ArticleTB> searchArticleTB(String aArticleTypetbID, String top) {
		return null;
	}
	/**
	 * 根据文章ID查询文章
	 */
	public ArticleTB searchArticleTBByID(String aId) {
		return null;
	}
	/**
	 * 根据文章ID修改文章
	 */
	public int updateArticleTB(String aId, ArticleTB articleTB) {
		return 0;
	}

}
