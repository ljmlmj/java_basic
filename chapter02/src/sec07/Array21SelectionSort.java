package sec07;

public class Array21SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * [선택정렬] 내림차순 정렬
		 */
		
		int[] age = null;
		int small = 0;
		age = new int[] {3, 5, 4, 1, 2};
		
		for (int i = 0; i < age.length; i++) {
			for (int j = i + 1; j < age.length; j++) {
				if (age[i] < age[j] ) {
					small = age[i];
					age[i] = age[j];
					age[j] = small; 
				}
			}
		}
		
		for (int i : age) {
			System.out.println(i + "\t");
		}
	}
}
