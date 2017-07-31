package dao;

import java.util.List;

import entity.NvntitleTB;

/**
 * 导航接口
 * @author Administrator
 *
 */
public interface NvntitleTBDao {
	int updateNvntitleTB(String nId,String nNontent);//修改导航(通过获取的id和新的导航内容)
	List<NvntitleTB> searchNvntitleTB();//查看所有导航
}
