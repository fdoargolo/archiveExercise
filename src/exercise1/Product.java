package exercise1;

public class Product {
	public String name;
	public Double price;
	public Integer quantity;
	private double finalPrice;
	
	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.finalPrice = price * quantity;
	}

	@Override
	public String toString() {
		return name + "," + finalPrice;
	}	
	
}
