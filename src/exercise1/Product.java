package exercise1;

public class Product {
	public String name;
	public double price;
	public int quantity;
	public double finalPrice;
	
	public Product(String name, double price, int quantity) {
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
