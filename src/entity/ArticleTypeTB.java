package entity;
/**
 * ����������
 * @author xujun
 *
 */
public class ArticleTypeTB {
	private String aId;//��������ID
	private String aName;//������������
	public ArticleTypeTB() {
		super();
	}
	public ArticleTypeTB(String aName) {
		super();
		this.aName = aName;
	}
	public ArticleTypeTB(String aId, String aName) {
		super();
		this.aId = aId;
		this.aName = aName;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	
}
