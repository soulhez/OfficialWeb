package entity;
/**
 * ������
 * @author xujun
 */
public class ArticleTB {
	private String aId;//����ID
	private String aArticleTitle;//���±���
	private String aContent;//��������
	private String aNewDate;//���´���ʱ��
	private String aArticleTypetbID;//��������������ID
	public ArticleTB() {
		super();
	}
	public ArticleTB(String aArticleTitle, String aContent, String aNewDate,
			String aArticleTypetbID) {
		super();
		this.aArticleTitle = aArticleTitle;
		this.aContent = aContent;
		this.aNewDate = aNewDate;
		this.aArticleTypetbID = aArticleTypetbID;
	}
	public ArticleTB(String aId, String aArticleTitle, String aContent,
			String aNewDate, String aArticleTypetbID) {
		super();
		this.aId = aId;
		this.aArticleTitle = aArticleTitle;
		this.aContent = aContent;
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
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
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
