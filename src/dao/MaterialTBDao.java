package dao;

import java.util.List;

import entity.MaterialTB;

/**
 * �زĽӿ�
 * @author Administrator
 *
 */
public interface MaterialTBDao {
	//�����ز�ID�޸��ز�
	int updateMaterialTB(String mId,MaterialTB materialTB);
	//�����ز����Ͳ�ѯ�ز�����
	String searchMaterialTBmName(String mType);
	//�����ز����Ͳ�ѯ�����͵��زļ���
	List<String> searchMaterialTB(String mType);
	
}
