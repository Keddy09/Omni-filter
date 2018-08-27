package beans;

public class WTBean {

	String brand;
	String size;
	int bust;
	int waist;
	int hip;
	int shoulder;
	
	public WTBean() {
		super();
	}
	public WTBean(String brand, String size, int bust, int waist, int hip, int shoulder) {
		super();
		this.brand = brand;
		this.size = size;
		this.bust = bust;
		this.waist = waist;
		this.hip = hip;
		this.shoulder = shoulder;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public int getShoulder() {
		return shoulder;
	}
	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}
	
}
