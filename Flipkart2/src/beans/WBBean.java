package beans;

public class WBBean {
	String brand;
	String size;
	int waist;
	int hip;
	int inseem;
	
	
	
	public WBBean() {
		super();
	}
	public WBBean(String brand, String size, int waist, int hip, int inseem) {
		super();
		this.brand = brand;
		this.size = size;
		this.waist = waist;
		this.hip = hip;
		this.inseem = inseem;
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
	public int getInseem() {
		return inseem;
	}
	public void setInseem(int inseem) {
		this.inseem = inseem;
	}

}
