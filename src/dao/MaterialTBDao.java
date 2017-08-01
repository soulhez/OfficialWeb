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
	//根据素材类型查询此类型的素材集合
	List<MaterialTB> searchMaterialTB(String mType,String start,String end);
	List<MaterialTB> searchMaterialTBByName(String mType,String start,String end);
}
