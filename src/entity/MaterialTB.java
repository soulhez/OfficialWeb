package entity;
/**
 * 匼第濬
 * @author xujun
 *
 */
public class MaterialTB {
	private String mId;//匼第ID
	private String mName;//匼第靡備
	private String mType;//匼第濬倰
	public MaterialTB() {
		super();
	}
	public MaterialTB(String mName, String mType) {
		super();
		this.mName = mName;
		this.mType = mType;
	}
	public MaterialTB(String mId, String mName, String mType) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mType = mType;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	
}
