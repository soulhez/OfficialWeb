package entity;
/**
 * 文章类型类
 * @author xujun
 *
 */
public class ArticleTypeTB {
	private String aId;//文章类型ID
	private String aName;//文章类型名称
	private String aNvntitleTBid;//所属导航标题ID
	private String aNvntitleTBName;//所属导航标题ID
	public ArticleTypeTB() {
		super();
	}
	public ArticleTypeTB(String aName, String aNvntitleTBid,
			String aNvntitleTBName) {
		super();
		this.aName = aName;
		this.aNvntitleTBid = aNvntitleTBid;
		this.aNvntitleTBName = aNvntitleTBName;
	}
	public ArticleTypeTB(String aId, String aName, String aNvntitleTBid,
			String aNvntitleTBName) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aNvntitleTBid = aNvntitleTBid;
		this.aNvntitleTBName = aNvntitleTBName;
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
	public String getaNvntitleTBid() {
		return aNvntitleTBid;
	}
	public void setaNvntitleTBid(String aNvntitleTBid) {
		this.aNvntitleTBid = aNvntitleTBid;
	}
	public String getaNvntitleTBName() {
		return aNvntitleTBName;
	}
	public void setaNvntitleTBName(String aNvntitleTBName) {
		this.aNvntitleTBName = aNvntitleTBName;
	}
}
