package class26.exam02;

public class Product {
	public int id;
	public String name;
	public int price;
	public int quantity;
	public int amount;
	
	public Product() {
	}
	
	public Product(int id, String name, 
			int price, int quantity, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public int getAmount() {
		return this.price * this.quantity;
	}
	
	public void showProductInfo() {
		System.out.println("id : " + this.id);
		System.out.println("name : " + this.name);
		System.out.println("price : " + this.price);
		System.out.println("quantity : " +this.quantity);
		System.out.println("amount : " + this.amount);
	}
}
