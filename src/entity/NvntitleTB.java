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
	public NvntitleTB(String nNontent) {
		super();
		this.nContent = nNontent;
	}
	public NvntitleTB(String nId, String nNontent) {
		super();
		this.nId = nId;
		this.nContent = nNontent;
	}
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnNontent() {
		return nContent;
	}
	public void setnNontent(String nNontent) {
		this.nContent = nNontent;
	}
	
}
