package Model;

public class Product {
    private int proId;
	private String name;
	private String quantity;
	private String price;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
