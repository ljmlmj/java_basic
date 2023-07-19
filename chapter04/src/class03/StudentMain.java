package class03;

public class StudentMain {

	public static void main(String[] args) {
		
		Student[] students = new Student[8];
		
		// 학생 데이터를 생성해주는 메소드
		initData(students);
		
		// 학생 목록을 출력해주는 메소드
		printStudent(students);
		
		// 여학생들의 명단을 출력하는 메소드
		getGirlStudent(students);
		
		// 서울에 사는 3학년 학생들의 이름을 구해주는 메소드를 만들고 반환받은 이름을 main 메소드에서 출력하세요.
		String[] strName = getThirdSeoulStduent(students);
		for (String str : strName) {
			System.out.println(str);
		}
	}

	// 학생 데이터를 생성해주는 메소드
	private static void initData(Student[] students) {
		students[0] = new Student("1292001", "900424-1825409", "김광식", 3, "서울", 92);
		students[1] = new Student("1292002", "900305-1730021", "김정현", 3, "서울", 20);
		students[2] = new Student("1292003", "891021-2308302", "김현정", 4, "대전", 55);
		students[3] = new Student("1292301", "890902-2704012", "김현정", 2, "대구", 78);
		students[4] = new Student("1292303", "910715-1524390", "박광수", 3, "광주", 54);
		students[5] = new Student("1292305", "921011-1809003", "김우주", 4, "부산", 88);
		students[6] = new Student("1292501", "900825-1506390", "박철수", 3, "대전", 73);
		students[7] = new Student("1292502", "911011-1809003", "백태성", 3, "서울", 95);
	}
	
	// 학생 목록을 출력해주는 메소드
	private static void printStudent(Student[] students) {
		System.out.println("[학생명단]");
		System.out.println("학번\t주민번호\t\t이름\t학년\t주소\t학과");
		for (Student student : students) {
			System.out.println(student.getId() + "\t" + student.getJumin() + "\t"
								+ student.getName() + "\t" + student.getYear() + "\t"
								+ student.getAddress() + "\t" + student.getDepartment());
		}
		System.out.println();
	}
		
	// 여학생들의 명단을 출력하는 메소드
	private static void getGirlStudent(Student[] students) {
		System.out.println("[여학생 명단]");
		System.out.println("학번\t주민번호\t\t이름\t학년\t주소\t학과");
		for (Student student : students) {
			if (student.getJumin().substring(7, 8).equals("2")) {
				System.out.println(student.getId() + "\t" + student.getJumin() + "\t"
								+ student.getName() + "\t" + student.getYear() + "\t"
								+ student.getAddress() + "\t" + student.getDepartment());
			}
		}
		System.out.println();
	}

	// 서울에 사는 3학년 학생들의 이름을 구해주는 메소드
	private static String[] getThirdSeoulStduent(Student[] students) {
		System.out.println("[서울에 사는 3학년 학생]");
		String arrName = "";
		for (Student student : students) {
			if (student.getYear() == 3 && student.getAddress().equals("서울")) {
				arrName = arrName + student.getName() + ",";
			}
		}
		String[] resultName = arrName.split(",");
		return resultName;
	}
}
