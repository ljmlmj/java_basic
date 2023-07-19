package class24.exam01.mycompany;

import class24.exam01.hankook.SnowTire;
import class24.exam01.hyundai.Engine;
import class24.exam01.kumho.BigWidthTire;
import class24.exam01.kumho.Tire;

public class Car {
	Engine engine = new Engine();
	SnowTire tire1 = new SnowTire();
	BigWidthTire tire2 = new BigWidthTire();
	
	Tire tire10 = new Tire(); // kumho
	Tire tire11 = new Tire(); // hankook패키지의 Tire을 쓰려면 아래와 같이 복잡한 과정을 거쳐야 한다.
	
	class24.exam01.kumho.Tire tire3 = new class24.exam01.kumho.Tire();
	class24.exam01.hankook.Tire tire4 = new class24.exam01.hankook.Tire();
	
	public static void main(String[] args) {
		Car myCar = new Car();
	
	}
}
