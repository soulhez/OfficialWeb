package dao;

import java.util.List;

import entity.ArticleTB;
import entity.ArticleTypeTB;

/**
 * ���½ӿ�
 * @author Administrator
 *
 */
public interface ArticleTBDao {
	 int addArticleTB(String path,ArticleTB articleTB);//�������
	 int deleteArticleTB(String aId);//��������IDɾ������
	 int updateArticleTB(ArticleTB articleTB);//��������ID�޸�����
	//������������ID��ѯ���º������´���ʱ�併������
	 List<ArticleTB> searchArticleTB(String aArticleTypetbID,String start,String end);
	 ArticleTB searchArticleTBByID(String aId);//��������ID��ѯ����
	 ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID);//��������id��ѯ��������
}
