package dao;

import java.util.List;

import entity.NvntitleTB;

/**
 * �����ӿ�
 * @author Administrator
 *
 */
public interface NvntitleTBDao {
	int updateNvntitleTB(String nId,String nNontent);//�޸ĵ���
	List<NvntitleTB> searchNvntitleTB();//�鿴���е���
	NvntitleTB searchnNontent(String nNontent);
}
