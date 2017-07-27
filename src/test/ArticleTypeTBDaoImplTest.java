package test;

import java.util.List;

import dao.impl.ArticleTypeTBDaoImpl;
import entity.ArticleTypeTB;
/**
 * 文章类型测试类 
 * @author 22386
 *
 */
public class ArticleTypeTBDaoImplTest {
	public static void main(String[] args) {
		//添加文章类型Test
		ArticleTypeTB articleTypeTB=new ArticleTypeTB("标题二","1");
		int number=0;
		number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
		System.out.println("添加影响行数"+number);
		
		//根据所属导航标题id查询所有文章类型Test
		List<ArticleTypeTB> list=new ArticleTypeTBDaoImpl().searchArticleTypeTB("1");
		for (ArticleTypeTB item : list) {
			articleTypeTB=item;
			System.out.println("文章id"+item.getaId());
		}
		
		//根据文章id查询文章类型Test
		ArticleTypeTB articleTypeTB2=new ArticleTypeTBDaoImpl().searchArticleTypeTBByArticleTBId("3");
		System.out.println("根据文章ID查询类型"+articleTypeTB2.getaId());
		
		////修改文章类型Test
		number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB2.getaId(), articleTypeTB2);
		System.out.println("修改的影响行数"+number);
		
		//删除文章类型Test
		number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB("4");
		System.out.println("删除的影响行数"+number);
	}
}
