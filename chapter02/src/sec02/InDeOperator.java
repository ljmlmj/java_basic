package sec02;

/*
 * 산술연산자, 증감연산자 예제
 */
public class InDeOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 10;
		int z;
		
		x++;
		++x;
		System.out.println("x=" + x);
		System.out.println("-------------------");
		
		y--;
		--y;
		System.out.println("y=" + y);
		System.out.println("-------------------");

		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("-------------------");

		z = ++x;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("-------------------");

		z = ++x + y++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}

}
