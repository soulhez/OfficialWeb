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
	//�����ز����Ͳ�ѯ�����͵��زļ���
	List<MaterialTB> searchMaterialTB(String mType,String start,String end);
	List<MaterialTB> searchMaterialTBByName(String mType,String start,String end);
}
