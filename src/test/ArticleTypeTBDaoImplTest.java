package test;

import java.util.List;

import dao.impl.ArticleTypeTBDaoImpl;
import entity.ArticleTypeTB;
/**
 * �������Ͳ����� 
 * @author 22386
 *
 */
public class ArticleTypeTBDaoImplTest {
	public static void main(String[] args) {
		//�����������Test
		ArticleTypeTB articleTypeTB=new ArticleTypeTB("�����","1");
		int number=0;
		number=new ArticleTypeTBDaoImpl().addArticleTypeTB(articleTypeTB);
		System.out.println("���Ӱ������"+number);
		
		//����������������id��ѯ������������Test
		List<ArticleTypeTB> list=new ArticleTypeTBDaoImpl().searchArticleTypeTB("1");
		for (ArticleTypeTB item : list) {
			articleTypeTB=item;
			System.out.println("����id"+item.getaId());
		}
		
		//��������id��ѯ��������Test
		ArticleTypeTB articleTypeTB2=new ArticleTypeTBDaoImpl().searchArticleTypeTBByArticleTBId("3");
		System.out.println("��������ID��ѯ����"+articleTypeTB2.getaId());
		
		////�޸���������Test
		number=new ArticleTypeTBDaoImpl().updateArticleTypeTB(articleTypeTB2.getaId(), articleTypeTB2);
		System.out.println("�޸ĵ�Ӱ������"+number);
		
		//ɾ����������Test
		number=new ArticleTypeTBDaoImpl().deleteArticleTypeTB("4");
		System.out.println("ɾ����Ӱ������"+number);
	}
}
