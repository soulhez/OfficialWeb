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
	int updateArticleTypeTB(ArticleTypeTB articleTypeTB);//�޸���������
	//����������������id,��������������ģ����ѯ������������
	List<ArticleTypeTB> searchArticleTypeTB(String aNvntitleTBid,String aNvntitleTBName);
	ArticleTypeTB searchArticleTypeTBByArticleTypeTBName(String id);//������������id�����������Ͷ���
}
