package entity;
/**
 * ������
 * @author xujun
 *
 */
public class NvntitleTB {
	private String nId;//��������ID
	private String nNontent;//������������
	public NvntitleTB() {
		super();
	}
	public NvntitleTB(String nNontent) {
		super();
		this.nNontent = nNontent;
	}
	public NvntitleTB(String nId, String nNontent) {
		super();
		this.nId = nId;
		this.nNontent = nNontent;
	}
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnNontent() {
		return nNontent;
	}
	public void setnNontent(String nNontent) {
		this.nNontent = nNontent;
	}
	
}
