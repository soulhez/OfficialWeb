package dao;

import java.util.List;

import entity.ArticleTypeTB;

/**
 * �������ͽӿ�
 * @author Administrator
 *
 */
public interface ArticleTypeTBDao{
	int addArticleTypeTB(ArticleTypeTB articleTypeTB);//�����������
	int deleteArticleTypeTB(String aId);//ɾ����������
	int updateArticleTypeTB(String aId,ArticleTypeTB articleTypeTB);//�޸���������
	List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid);//����������������id��ѯ������������
	ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID);//��������id��ѯ��������
}
