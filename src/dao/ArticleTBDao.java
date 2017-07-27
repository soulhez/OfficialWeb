package dao;

import java.util.List;

import entity.ArticleTB;

/**
 * 文章接口
 * @author Administrator
 *
 */
public interface ArticleTBDao {
	 int addArticleTB(ArticleTB articleTB);//添加文章
	 int deleteArticleTB(String aId);//根据文章ID删除文章
	 int updateArticleTB(String aId,ArticleTB articleTB);//根据文章ID修改文章
	//根据文章类型ID查询文章后，以文章创建时间降序排列
	 List<ArticleTB> searchArticleTB(String aArticleTypetbID,String top);
	 ArticleTB searchArticleTBByID(String aId);//根据文章ID查询文章
}
