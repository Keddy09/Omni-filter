package beans;

public class CartBean {
	String email;
	int pid;
	String size;
	
	
	
	public CartBean() {
		super();
	}
	public CartBean(String email, int pid, String size) {
		super();
		this.email = email;
		this.pid = pid;
		this.size = size;
	}
	@Override
	public String toString() {
		return "Cart [email=" + email + ", pid=" + pid + ", size=" + size + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

}
