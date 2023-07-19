package sec08;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기초 데이터 만들기(배열 변수)
		String[] name={"PJH","JDW","AJH","HST","HTW","LWS","LSD","YJH","JSW","LKO"};
		int[] age={27,34,28,26,41,28,42,29,29,32};
		String[] phone={"010-8532-0537","010-9672-5257","010-9932-4536","010-4117-0975",
						"011-8975-7892","010-6251-6976","010-9482-6059","010-4845-0105",
						"010-6283-4849","010-4510-1609"};
		char[] gender={'F','M','F','M','M','F','M','M','F','M'};
		int[] pay={460,200,250,300,300,200,350,200,400,440};
		String[] country={"일본", "프랑스", "일본", "미국", "캐나다", "덴마크", "한국", "영국", "미국","한국"};
		
		// 1. 사원 정보 출력
		System.out.println("                         <<  사원 정보   >>");
		System.out.println("=================================================================");
		System.out.println("name    age     phone           gender  pay     country");
		System.out.println("-----------------------------------------------------------------");
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + "\t" + age[i] + "\t" + phone[i]
					+ "\t" + gender[i] + "\t" + pay[i] + "\t" + country[i]);
		}
		System.out.println("=================================================================");
	
		// 2. 남자 사원의 평균 연령 구하기
		int manCount = 0;		// 남자 사원 수
		int manSum = 0;			// 남자 사원 나이 합
		double manAvg = 0.0;	// 남자 사원 나이 평균
		for (int i = 0; i < gender.length; i++) {
			if (gender[i] == 'M') {
				manCount++;
				manSum = manSum + age[i];
			}
		}
		manAvg = (double) manSum / manCount;
		System.out.printf("2. 남자 사원의 숫자는 %d명이며 평균 연령은 %.1f세 입니다. \n", manCount, manAvg);
		
		// 3. 여성 사원들의 평균 급여 구하기
		int wmCount = 0;		// 여자 사원 수
		int paySum = 0;			// 여자 사원 급여 합
		double payAvg = 0;			// 여자 사원 급여 평균
		
		for (int i = 0; i < gender.length; i++) {
			if (gender[i] == 'F') {
				wmCount++;
				paySum += pay[i];
			}
		}
		payAvg = (double) paySum / wmCount;
		System.out.printf("3. 여자 사원의 숫자는 %d명이며 평균 급여는 %.1f입니다. \n", wmCount, payAvg);
		System.out.println();
		
		// 4. 일본에 근무하는 사원들의 이름과 연락처 구하기
		String nameString = "";
		String phonString = "";
		
		for (int i = 0; i < country.length; i++) {
			if (country[i].equals("일본")) {
				nameString = nameString + name[i] + ",";
				phonString = phonString + phone[i] + ",";
			}
		}
		String[] arrName = nameString.split(",");
		String[] arrPhone = phonString.split(",");
		
		for (int i = 0; i < arrPhone.length; i++) {
			System.out.printf("일본 사원 이름 : %s, 번호 : %s \n", arrName[i], arrPhone[i]);
		}
		System.out.println();
	}
}
