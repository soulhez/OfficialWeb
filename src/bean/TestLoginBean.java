package bean;

public class TestLoginBean {
	private String aEmail;
	private String aPwd;
	public TestLoginBean(String aEmail, String aPwd) {
		super();
		this.aEmail = aEmail;
		this.aPwd = aPwd;
	}
	public TestLoginBean() {
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
	
	
}
