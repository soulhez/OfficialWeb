package test;

import java.util.List;

import dao.impl.NvntitleTBDaoImpl;

import entity.NvntitleTB;

/**
 * ����������
 * @author xujun
 *
 */
public class NvntitleTBTest {
	public static void main(String[] args) {
		//�鿴���е���
		List<NvntitleTB> list=new NvntitleTBDaoImpl().searchNvntitleTB();
		for(NvntitleTB l:list){
			//System.out.println(l.getnNontent());
		}
		//�޸ĵ���
		int num=new NvntitleTBDaoImpl().updateNvntitleTB("1", "���");
		System.out.println(num);
	}
}
