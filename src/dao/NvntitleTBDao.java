package dao;

import java.util.List;

import entity.NvntitleTB;

/**
 * 导航接口
 * @author Administrator
 *
 */
public interface NvntitleTBDao {
	int updateNvntitleTB(String nId,String nNontent);//修改导航
	List<NvntitleTB> searchNvntitleTB();//查看所有导航
	NvntitleTB searchnNontent(String nNontent);
}
