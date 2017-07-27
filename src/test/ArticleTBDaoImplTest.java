package test;

import java.util.List;

import dao.impl.ArticleTBDaoImpl;
import entity.ArticleTB;

/**
 * ���²�����
 * @author 22386
 *
 */
public class ArticleTBDaoImplTest {
	public static void main(String[] args) {
		//�������Test
		ArticleTB articleTB=new ArticleTB("���±���","��������","1992-12-12","1");
		int number=0;
		number=new ArticleTBDaoImpl().addArticleTB(articleTB);
		System.out.println("���Ӱ������"+number);
		
		//������������ID��ѯ���º������´���ʱ�併������Test
		List<ArticleTB> list=new ArticleTBDaoImpl().searchArticleTB("1", "0", "5");
		for (ArticleTB item : list) {
			articleTB=item;
			System.out.println("����id"+item.getaId());
		}
		
		//��������ID��ѯ����Test
		ArticleTB articleTB2=new ArticleTBDaoImpl().searchArticleTBByID(articleTB.getaId());
		System.out.println("��������ID��ѯ���³ɹ�"+articleTB2.getaId());
		
		//��������ID�޸�����Test
		number=new ArticleTBDaoImpl().updateArticleTB(articleTB2.getaId(), articleTB2);
		System.out.println("�޸ĵ�Ӱ������"+number);
		
		//��������IDɾ������Test
		number=new ArticleTBDaoImpl().deleteArticleTB(articleTB2.getaId());
		System.out.println("ɾ����Ӱ������"+number);
	}
}
