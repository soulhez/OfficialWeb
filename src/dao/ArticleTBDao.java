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
	 int deleteArticleTB(String aId,String path);//��������IDɾ������
	 int updateArticleTB(ArticleTB articleTB,String path);//��������ID�޸�����
	//������������ID��ѯ���º������´���ʱ�併������
	 List<ArticleTB> searchArticleTB(String aArticleTypetbID,String aArticleTitle,String start,String end);
	 ArticleTB searchArticleTBByID(String aId,String path);//��������ID��ѯ����
	 ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID);//��������id��ѯ��������
	 String getTitleById(String id);//��������id�������±���
}
