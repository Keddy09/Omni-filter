package beans;

public class OmniBean {
	String email;
	String name;
	String gender;
	int shoulder;
	int bust;
	int waist;
	int hip;
	float shoe;
	int fid;
	
	
	
	public OmniBean() {
		super();
	}
	public OmniBean(String email, String name, String gender, int shoulder, int bust, int waist, int hip, float shoe, int fid) {
		super();
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.shoulder = shoulder;
		this.bust = bust;
		this.waist = waist;
		this.hip = hip;
		this.shoe = shoe;
		this.fid = fid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getShoulder() {
		return shoulder;
	}
	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}
	public int getBust() {
		return bust;
	}
	public void setBust(int bust) {
		this.bust = bust;
	}
	public int getWaist() {
		return waist;
	}
	public void setWaist(int waist) {
		this.waist = waist;
	}
	public int getHip() {
		return hip;
	}
	public void setHip(int hip) {
		this.hip = hip;
	}
	public float getShoe() {
		return shoe;
	}
	public void setShoe(float shoe) {
		this.shoe = shoe;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "OmniBean [email=" + email + ", name=" + name + ", gender=" + gender + ", shoulder=" + shoulder
				+ ", bust=" + bust + ", waist=" + waist + ", hip=" + hip + ", shoe=" + shoe + ", fid=" + fid
				+ ", getEmail()=" + getEmail() + ", getName()=" + getName() + ", getGender()=" + getGender()
				+ ", getShoulder()=" + getShoulder() + ", getBust()=" + getBust() + ", getWaist()=" + getWaist()
				+ ", getHip()=" + getHip() + ", getShoe()=" + getShoe() + ", getFid()=" + getFid() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
