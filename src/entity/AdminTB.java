package entity;
/**
 * 管理员类
 * @author Administrator
 *
 */
public class AdminTB {
	private String aID;//管理员ID
	private String aUserName;//管理员姓名
	private String aEmail;//管理员登录邮箱
	private String aPwd;//管理员密码
	public AdminTB() {
		super();
	}
	public AdminTB(String aUserName, String aEmail, String aPwd) {
		super();
		this.aUserName = aUserName;
		this.aEmail = aEmail;
		this.aPwd = aPwd;
	}
	public AdminTB(String aID, String aUserName, String aEmail, String aPwd) {
		super();
		this.aID = aID;
		this.aUserName = aUserName;
		this.aEmail = aEmail;
		this.aPwd = aPwd;
	}
	public String getaID() {
		return aID;
	}
	public void setaID(String aID) {
		this.aID = aID;
	}
	public String getaUserName() {
		return aUserName;
	}
	public void setaUserName(String aUserName) {
		this.aUserName = aUserName;
	}
	public String getaEmail() {
		return aEmail;
	}
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	
}
