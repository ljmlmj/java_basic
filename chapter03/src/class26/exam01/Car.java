package class26.exam01;

public class Car {
	String maker;
	String model;
	int cc;
	String color;
	int price;
	int maxSpeed;
	int speed;
	
	Car(){	
	}
	
	Car(String maker, String model, int cc, String color, int price, 
			int maxSpeed, int speed){
		this.maker = maker;
		this.model = model;
		this.cc = cc;
		this.color = color;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	public void showCarInfo(){
		System.out.println("maker : " + this.maker);
		System.out.println("model : " + this.model);
		System.out.println("cc : " + this.cc);
		System.out.println("color : " + this.color);
		System.out.println("price : " + this.price);
		System.out.println("maxSpeed : " + this.maxSpeed);
		System.out.println("speed : " + this.speed);
	}
}
