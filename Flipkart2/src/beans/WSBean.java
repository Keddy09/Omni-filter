package beans;

public class WSBean {
	String brand;
	int uk;
	int us;
	float length;
	
	public WSBean() {
		super();
	}
	public WSBean(String brand, int uk, int us, float length) {
		super();
		this.brand = brand;
		this.uk = uk;
		this.us = us;
		this.length = length;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getUk() {
		return uk;
	}
	public void setUk(int uk) {
		this.uk = uk;
	}
	public int getUs() {
		return us;
	}
	public void setUs(int us) {
		this.us = us;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	

}
