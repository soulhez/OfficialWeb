package test;


import java.util.List;

import dao.impl.MaterialTBDaoImpl;

/**
 * �زĲ�����
 * @author xujun
 *
 */
public class MaterialTBTest {
	public static void main(String[] args) {
		//�����ز����Ͳ�ѯ�ز�����
		String name=new MaterialTBDaoImpl().searchMaterialTBmName("ֲ��");
		System.out.println(name);
		//�����ز����Ͳ�ѯ�����͵��زļ���
		List<String> list=new MaterialTBDaoImpl().searchMaterialTB("ֲ��");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
