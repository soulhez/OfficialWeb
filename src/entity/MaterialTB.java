package entity;
/**
 * �ز���
 * @author xujun
 *
 */
public class MaterialTB {
	private String mId;//�ز�ID
	private String mName;//�ز�����
	private String mType;//�ز�����
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
