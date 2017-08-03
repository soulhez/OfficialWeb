package dao;

import java.util.List;

import entity.MaterialTB;


/**
 * 素材接口
 * @author Administrator
 *
 */
public interface MaterialTBDao {
	//根据素材类型查询素材名称
	MaterialTB searchMaterialTBmName(String mType);
	//根据素材类型和类型名称查询此类型的素材集合
	List<MaterialTB> searchMaterialTB(String mType,String mName,String start,String end);
	List<String> searchMaterialTBType();//查询所有素材类型返回素材类型集合
}
