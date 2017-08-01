package dao;

import java.util.List;

import entity.ArticleTypeTB;

/**
 * 文章类型接口
 * @author Administrator
 *
 */
public interface ArticleTypeTBDao{
	int addArticleTypeTB(ArticleTypeTB articleTypeTB);//添加文章类型
	int deleteArticleTypeTB(String aId);//删除文章类型
	int updateArticleTypeTB(ArticleTypeTB articleTypeTB);//修改文章类型
	//根据所属导航标题id查询所有文章类型
	List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid);
	ArticleTypeTB searchArticleTypeTBByArticleTypeTBName(String id);//根据文章类型id返回文章类型对象
	List<ArticleTypeTB> searchArticleTypeTBByName(String aNvntitleTBName);//根据文章类型名称模糊查询
}
