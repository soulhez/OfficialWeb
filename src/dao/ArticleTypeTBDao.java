package dao;

import java.util.List;

import entity.ArticleTypeTB;

/**
 * 文章类型
 * @author Administrator
 *
 */
public interface ArticleTypeTBDao {
	int addArticleTypeTB(ArticleTypeTB articleTypeTB);//添加文章类型
	int deleteArticleTypeTB(String aId);//删除文章类型
	int updateArticleTypeTB(String aId,ArticleTypeTB articleTypeTB);//修改文章类型
	List<ArticleTypeTB> searchArticleTypeTB(String );//查询所有文章类型
	ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID);//查询文章id查询文章类型
}
