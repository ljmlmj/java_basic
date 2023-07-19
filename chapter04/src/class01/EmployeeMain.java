package class01;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee[] employees = new Employee[10];
		employees[0] = new Employee("A", 28, 400, "KR", 10, "정규");
	    employees[1] = new Employee("B", 27, 600, "KR", 15, "정규");
	    employees[2] = new Employee("C", 26, 280, "JP", 1, "비정규");
	    employees[3] = new Employee("D", 25, 360, "JP", 2, "비정규");
	    employees[4] = new Employee("E", 23, 270, "RU", 1, "정규");
	    employees[5] = new Employee("F", 27, 390, "AM", 4, "정규");
	    employees[6] = new Employee("G", 31, 330, "SI", 3, "정규");
	    employees[7] = new Employee("H", 35, 280, "CA", 2, "비정규");
	    employees[8] = new Employee("I", 38, 450, "FR", 10, "정규");
	    employees[9] = new Employee("J", 45, 600, "JP", 15, "정규");
		
		// 1. 배열을 받아서 전 사원 목록을 출력하는 메소드 생성
		System.out.println("1. 전 사원들의 목록");
		printEmployee(employees);
		System.out.println();
		
		// 2. 정규직 평균 급여를 출력하는 메소드 생성
		double avg = getSalAvg(employees);
		System.out.println("2. 정규직 직원들의 평균 급여는 : " + Math.round(avg * 100) / 100.0);
		System.out.println();
		
		// 3. 한국 사원들의 평균 급여를 출력하는 메소드 생성
		avg = 0.0;
		avg = getKorAvg(employees);
		System.out.println("3. 한국 직원들의 평균 급여는 : " + Math.round(avg * 100) / 100.0);
		System.out.println();
	}
	
	// 1. 배열을 받아서 전 사원 목록을 출력하는 메소드
	private static void printEmployee(Employee[] employees) {
		System.out.println("==============================================");
		System.out.println("이름\t나이\t급여\t지역\t근무연차\t사원구분");
		System.out.println("----------------------------------------------");

		for (Employee emps : employees) {
			System.out.println(emps.getName() + "\t" + emps.getAge() + "\t" + emps.getSalary() + "\t"
					+ emps.getLocal() + "\t" + emps.getTerms() + "\t" + emps.getGubun());	
		}
		System.out.println("==============================================");
	}
	
	// 2. 정규직 평균 급여를 출력하는 메소드
	private static double getSalAvg(Employee[] employees) {
		int count = 0;
		int sum = 0;
		double salAvg = 0.0;
		
		for (Employee emps : employees) {
			if(emps.getGubun().equals("정규")) {
				sum += emps.getSalary();
				count++;				
			}
		}
		salAvg = (double) sum / count;
		return salAvg;
		
	}
	
	// 3. 한국 사원들의 평균 급여를 출력하는 메소드
	private static double getKorAvg(Employee[] employees) {
		int count = 0;
		int sum = 0;
		double salAvg = 0.0;
		for (Employee emps : employees) {
			if(emps.getLocal().equals("KR")) {
				sum += emps.getSalary();
				count++;
			}
		}
		salAvg = (double) sum / count;
			return salAvg;
	}
}