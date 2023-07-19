package class26.exam01;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		Car car2 = new Car("기아차", "K9", 3000, "black", 6000, 300, 150);

		car1.maker = "현대차";
		car1.model = "그랜저";
		car1.cc = 2000;
		car1.color = "white";
		car1.price = 4000;
		car1.maxSpeed = 250;
		car1.speed = -120;
		
		System.out.println("car1.maker : " + car1.maker);
		System.out.println("car1.model : " + car1.model);
		System.out.println("car1.cc : " + car1.cc);
		System.out.println("car1.color : " + car1.color);
		System.out.println("car1.price : " + car1.price);
		System.out.println("car1.maxSpeed : " + car1.maxSpeed);
		System.out.println("car1.speed : " + car1.speed);
		System.out.println();
		
		System.out.println("car2.maker : " + car2.maker);
		System.out.println("car2.model : " + car2.model);
		System.out.println("car2.cc : " + car2.cc);
		System.out.println("car2.color : " + car2.color);
		System.out.println("car2.price : " + car2.price);
		System.out.println("car2.maxSpeed : " + car2.maxSpeed);
		System.out.println("car2.speed : " + car2.speed);
		System.out.println();
		
		// 자동차 객체의 값 출력하는 또다른 방법(showCarInfo 메소드)
		// 첫번째 자동차 객체의 값 출력
		car1.showCarInfo();
		System.out.println();
		// 두번째 자동차 객체의 값 출력
		car2.showCarInfo();
	}

}
