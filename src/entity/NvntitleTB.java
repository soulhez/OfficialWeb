package entity;
/**
 * 导航类
 * @author xujun
 *
 */
public class NvntitleTB {
	private String nId;//导航标题ID
	private String nContent;//导航标题内容
	
	public NvntitleTB() {
		super();
	}

	public NvntitleTB(String nContent) {
		super();
		this.nContent = nContent;
	}

	public NvntitleTB(String nId, String nContent) {
		super();
		this.nId = nId;
		this.nContent = nContent;
	}

	public String getnId() {
		return nId;
	}

	public void setnId(String nId) {
		this.nId = nId;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	
}
