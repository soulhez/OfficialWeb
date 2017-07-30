package test;

import java.util.List;

import dao.impl.ArticleTBDaoImpl;
import entity.ArticleTB;
import entity.ArticleTypeTB;

/**
 * 文章测试类
 * @author 22386
 *
 */
public class ArticleTBDaoImplTest {
	public static void main(String[] args) {
		//添加文章Test
		ArticleTB articleTB=new ArticleTB("文章标题","文章内容","1992-12-12","1");
		int number=0;
		number=new ArticleTBDaoImpl().addArticleTB("",articleTB);
		System.out.println("添加影响行数"+number);
		
		/**根据文章类型ID查询文章后，以文章创建时间降序排列Test
		List<ArticleTB> list=new ArticleTBDaoImpl().searchArticleTB("1", "0", "5");
		for (ArticleTB item : list) {
			articleTB=item;
			System.out.println("文章id"+item.getaId());
		}
		//根据文章id查询文章类型Test
		ArticleTypeTB articleTypeTB2=new ArticleTBDaoImpl().searchArticleTypeTBByArticleTBId(articleTB.getaId());
		System.out.println("根据文章ID查询类型"+articleTypeTB2.getaId());
		*/
		//根据文章ID查询文章Test
//		ArticleTB articleTB2=new ArticleTBDaoImpl().searchArticleTBByID(articleTB.getaId());
//		System.out.println("根据文章ID查询文章成功"+articleTB2.getaArticlePath());
		/**
		//根据文章ID修改文章Test
		number=new ArticleTBDaoImpl().updateArticleTB(articleTB2.getaId(), articleTB2);
		System.out.println("修改的影响行数"+number);
		
		//根据文章ID删除文章Test
		number=new ArticleTBDaoImpl().deleteArticleTB(articleTB2.getaId());
		System.out.println("删除的影响行数"+number);
		*/
	}
}
