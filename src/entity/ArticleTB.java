package entity;
/**
 * 文章类
 * @author xujun
 */
public class ArticleTB {
	private String aId;//文章ID
	private String aArticleTitle;//文章标题
	private String aArticlePath;//文章内容
	private String aNewDate;//文章创建时间
	private String aArticleTypetbID;//关联的文章类型ID
	public ArticleTB() {
		super();
	}
	
	public ArticleTB(String aArticleTitle, String aArticlePath,
			String aNewDate, String aArticleTypetbID) {
		super();
		this.aArticleTitle = aArticleTitle;
		this.aArticlePath = aArticlePath;
		this.aNewDate = aNewDate;
		this.aArticleTypetbID = aArticleTypetbID;
	}
	public ArticleTB(String aId, String aArticleTitle, String aArticlePath,
			String aNewDate, String aArticleTypetbID) {
		super();
		this.aId = aId;
		this.aArticleTitle = aArticleTitle;
		this.aArticlePath = aArticlePath;
		this.aNewDate = aNewDate;
		this.aArticleTypetbID = aArticleTypetbID;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaArticleTitle() {
		return aArticleTitle;
	}

	public void setaArticleTitle(String aArticleTitle) {
		this.aArticleTitle = aArticleTitle;
	}

	public String getaArticlePath() {
		return aArticlePath;
	}

	public void setaArticlePath(String aArticlePath) {
		this.aArticlePath = aArticlePath;
	}

	public String getaNewDate() {
		return aNewDate;
	}

	public void setaNewDate(String aNewDate) {
		this.aNewDate = aNewDate;
	}

	public String getaArticleTypetbID() {
		return aArticleTypetbID;
	}

	public void setaArticleTypetbID(String aArticleTypetbID) {
		this.aArticleTypetbID = aArticleTypetbID;
	}
}
