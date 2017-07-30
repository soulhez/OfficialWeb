package entity;
/**
 * ������
 * @author xujun
 */
public class ArticleTB {
	private String aId;//����ID
	private String aArticleTitle;//���±���
	private String aArticlePath;//��������
	private String aNewDate;//���´���ʱ��
	private String aArticleTypetbID;//��������������ID
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
