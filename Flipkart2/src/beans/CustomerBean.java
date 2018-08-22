package beans;

public class CustomerBean {
    String email;
	String fname;
	String lname;
	String phone;
	String pwd;
	public CustomerBean() {
		
	}
	
	public CustomerBean(String email, String fname, String lname, String phone, String pwd) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.pwd = pwd;
	}
	public CustomerBean(String email, String fname, String lname, String phone) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
