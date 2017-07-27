package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.MaterialTBDao;
import entity.MaterialTB;

/**
 * 素材实现类
 * @author Administrator
 *
 */
public class MaterialTBDaoImpl extends BaseDao implements MaterialTBDao{
	/**
	 * 根据素材类型查询此类型的素材集合
	 */
	public List<String> searchMaterialTB(String mType) {
		return null;
	}
	/**
	 * 根据素材类型查询素材名称
	 */
	public String searchMaterialTBmName(String mType) {
		return null;
	}
	/**
	 * 根据素材ID修改素材
	 */
	public int updateMaterialTB(String mId, MaterialTB materialTB) {
		return 0;
	}

}
