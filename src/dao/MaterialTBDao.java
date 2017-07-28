package dao;

import java.util.List;


/**
 * 素材接口
 * @author Administrator
 *
 */
public interface MaterialTBDao {
	//根据素材类型查询素材名称
	String searchMaterialTBmName(String mType);
	//根据素材类型查询此类型的素材集合
	List<String> searchMaterialTB(String mType);
	
}
