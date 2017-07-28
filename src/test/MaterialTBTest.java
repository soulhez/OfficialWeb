package test;


import java.util.List;

import dao.impl.MaterialTBDaoImpl;

/**
 * 素材测试类
 * @author xujun
 *
 */
public class MaterialTBTest {
	public static void main(String[] args) {
		//根据素材类型查询素材名称
		String name=new MaterialTBDaoImpl().searchMaterialTBmName("植物");
		System.out.println(name);
		//根据素材类型查询此类型的素材集合
		List<String> list=new MaterialTBDaoImpl().searchMaterialTB("植物");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
