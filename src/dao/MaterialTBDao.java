package dao;

import java.util.List;


/**
 * �زĽӿ�
 * @author Administrator
 *
 */
public interface MaterialTBDao {
	//�����ز����Ͳ�ѯ�ز�����
	String searchMaterialTBmName(String mType);
	//�����ز����Ͳ�ѯ�����͵��زļ���
	List<String> searchMaterialTB(String mType);
	
}
