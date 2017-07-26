package bean;

public class TestLoginBean {
	private String name;
	private String pwd;
	private String aa;
	
	public TestLoginBean(String name, String pwd, String aa) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.aa = aa;
	}
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public TestLoginBean(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public TestLoginBean() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
