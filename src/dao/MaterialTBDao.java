package dao;

import java.util.List;

import entity.MaterialTB;


/**
 * �زĽӿ�
 * @author Administrator
 *
 */
public interface MaterialTBDao {
	//�����ز����Ͳ�ѯ�ز�����
	MaterialTB searchMaterialTBmName(String mType);
	//�����ز����ͺ��������Ʋ�ѯ�����͵��زļ���
	List<MaterialTB> searchMaterialTB(String mType,String mName,String start,String end);
	List<String> searchMaterialTBType();//��ѯ�����ز����ͷ����ز����ͼ���
}
