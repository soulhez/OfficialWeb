package dao;

import java.util.List;

import entity.MaterialTB;

/**
 * �ز�
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
