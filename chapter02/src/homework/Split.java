package homework;

public class Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "01-1-234-5678";
		String[] hashNum = str.split("-");
		
		String hash1 = hashNum[0];
		String hash2 = hashNum[1];
		String hash3 = hashNum[2];
		String hash4 = hashNum[3];
		
		System.out.println("hash1 : " + hash1);
		System.out.println("hash2 : " + hash2);
		System.out.println("hash3 : " + hash3);
		System.out.println("hash4 : " + hash4);
		
		String str2 = "서울,대전,대구,부산,인천,울산";
		String[] cityArr = str2.split(",");
		
		for (int i=0; i<cityArr.length; i++) {
			System.out.println(cityArr[i]);
		}		
	}
}
