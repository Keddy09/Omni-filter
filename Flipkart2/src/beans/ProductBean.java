package beans;
public class ProductBean {
	int pid;
	String gender;
	String brand;
	String category;
	String type;
	String description;
	String color;
	String price;
	String image;
	
	
	
	public ProductBean() {
		super();
	}

	public ProductBean(int pid, String gender, String brand, String category, String type, String description,
			String color, String price, String image) {
		super();
		this.pid = pid;
		this.gender = gender;
		this.brand = brand;
		this.category = category;
		this.type = type;
		this.description = description;
		this.color = color;
		this.price = price;
		this.image = image;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
