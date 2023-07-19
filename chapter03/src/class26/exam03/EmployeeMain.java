package class26.exam03;

/**
 * 실행클래스
 * 객체 생성 방식
 * 1. 빈 객체 생성 후 값 저장
 * 2. 객체 생성하면서 초기값 전달(값 저장)
 */
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 빈 객체 생성
		Employee em = new Employee();
		
		// 1.1 빈 객체의 필드에 값 저장
		em.empNo = 2005031002;
		em.eName = "배준섭";
		em.position = "과장";
		em.salary = 500;
		
		// 1.2 객체의 정보 조회 (출력)
		System.out.println(em.empNo);
		System.out.println(em.eName);
		System.out.println(em.position);
		System.out.println(em.salary);
		System.out.println();
		
		// 2. 오버로딩 생성자 활용한 객체 생성
		Employee em2 = new Employee(2005031002, "김홍철", "사원", -250);
		
		// 2.2 객체의 정보 조회 (출력)
		System.out.println(em2.empNo);
		System.out.println(em2.eName);
		System.out.println(em2.position);
		System.out.println(em2.salary);
		System.out.println();
		
		// 3. 객체 배열
		Employee[] emps = new Employee[3];
		emps[0] = new Employee(2023010001, "김수희", "대리", 310); 
		emps[1] = new Employee(2023010001, "박미선", "사원", 280);
		emps[2] = new Employee(2023010001, "최무림", "과장", 400);
		
		// 3.4 for문
		System.out.println("<<객체 배열을 통한 사원 정보 조회 : for문>>");
		System.out.println("=====================================");
		System.out.println("사원번호\t\t이름\t직위\t봉급");
		System.out.println("-------------------------------------");
		
		for (int i = 0; i < emps.length; i++) {
			System.out.println(emps[i].empNo + "\t" + emps[i].eName + "\t" + 
					emps[i].position + "\t" + emps[i].salary);
		}
		System.out.println("-------------------------------------");
		System.out.println();
		
		// 3.5 향상된 for문
		System.out.println("<<객체 배열을 통한 사원 정보 조회 - 향상된 for문>>");
		System.out.println("=====================================");
		System.out.println("사원번호\t\t이름\t직위\t봉급");
		System.out.println("-------------------------------------");
		
		for (Employee i : emps) {
			System.out.println(i.empNo + "\t" + i.eName + "\t" + 
					i.position + "\t" + i.salary);
		}
		System.out.println("-------------------------------------");
		System.out.println();
		
		// 6. 전 사원들의 급여 총액
		int sum = 0;
		
		for (Employee employee : emps) {
			sum += employee.salary;
		}
		System.out.printf("전 사원의 급여 총액은 %d입니다.\n", sum);
	}
}
