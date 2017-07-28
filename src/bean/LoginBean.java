package bean;

public class LoginBean {
	private String aEmail;
	private String aPwd;
	public LoginBean(String aEmail, String aPwd) {
		super();
		this.aEmail = aEmail;
		this.aPwd = aPwd;
	}
	public LoginBean() {
		super();
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
	public boolean isLogin(){
		if (this.aEmail=="") {
			return false;
		}
		if (this.aPwd=="") {
			return false;
		}
		return true;
	}
	
}
