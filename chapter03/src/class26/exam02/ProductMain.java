package class26.exam02;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product1 = new Product();
		Product product2 = new Product(202103001, "세탁기", 250, -15, -3750);
		
		product1.id = 202103001;
		product1.name = "냉장고";
		product1.price = 500;
		product1.quantity = 5;
		product1.amount = 2500;
		
		product1.showProductInfo();
		System.out.println();
		product2.showProductInfo();
		System.out.println();
		
		System.out.println(product1.getAmount());
		System.out.println(product2.getAmount());
	}

}
