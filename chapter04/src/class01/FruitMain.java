package class01;

/**
 * 실행 클래스
 */

public class FruitMain {

	public static void main(String[] args) {
		
		// 객체 한 개 생성
		Fruit peach = new Fruit();
		peach.setName("복숭아");
		peach.setPrice(6500);
		peach.setQuantity(5);
		printFruit(peach);
		System.out.println();
		
		// 객체 5개 생성
		Fruit apple = new Fruit("사과", 2000, 5);
		Fruit mango = new Fruit("망고", 1000, 2);
		Fruit banana = new Fruit("바나나", 2500, 3);
		Fruit pineapple = new Fruit("파인애플", 5000, 1);
		Fruit orange = new Fruit("오렌지", 6000, 4);
		printFruit(apple, mango, banana, pineapple, orange);
		System.out.println();
		
		Fruit[] fruitArr = new Fruit[5];
		fruitArr[0] = apple;
		fruitArr[1] = mango;
		fruitArr[2] = banana;
		fruitArr[3] = pineapple;
		fruitArr[4] = orange;
		printFruit(fruitArr);
	}

	private static void printFruit(Fruit a) {
		System.out.println("과일 이름 : " + a.getName());
		System.out.println("가격 : " + a.getPrice());
		System.out.println("갯수 : " + a.getQuantity());
	}
	
	private static void printFruit(Fruit a, Fruit b, Fruit c, Fruit d, Fruit e) {
		System.out.println("이름 : " + a.getName() + "\t가격 : " + a.getPrice() + "\t갯수 : " + a.getQuantity()); 
		System.out.println("이름 : " + b.getName() + "\t가격 : " + b.getPrice() + "\t갯수 : " + b.getQuantity()); 
		System.out.println("이름 : " + c.getName() + "\t가격 : " + c.getPrice() + "\t갯수 : " + c.getQuantity()); 
		System.out.println("이름 : " + d.getName() + "\t가격 : " + d.getPrice() + "\t갯수 : " + d.getQuantity()); 
		System.out.println("이름 : " + e.getName() + "\t가격 : " + e.getPrice() + "\t갯수 : " + e.getQuantity()); 
	}
	private static void printFruit(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("이름 : " + arr[i].getName() + "\t가격 : " + arr[i].getPrice() + "\t갯수 : " +arr[i].getQuantity());
		}
	}
}
