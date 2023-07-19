package sec06;

public class For1To100Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for (int i=1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1 ~ 100까지의 합 : " + sum);
	}
}
