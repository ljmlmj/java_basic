package sec06;

public class While1T010Print {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		while (true) {
			if (i > 10) {
				break;
			}
			System.out.print(i + " ");
			i++;
			
		}
	}
}
