package test;

import java.util.List;

import dao.impl.NvntitleTBDaoImpl;

import entity.NvntitleTB;

/**
 * 导航测试类
 * @author xujun
 *
 */
public class NvntitleTBTest {
	public static void main(String[] args) {
		//查看所有导航
		List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
		for(NvntitleTB l:list){
			//System.out.println(l.getnNontent());
		}
		//修改导航
		int num=new NvntitleTBDaoImpl().updateNvntitleTB("1", "徐军");
		System.out.println(num);
	}
}
