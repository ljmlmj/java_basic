package class05;

public class DepartmentMain {

	public static void main(String[] args) {
		
		// Department type의 배열 변수 
		DepartmentData dep = new DepartmentData();	// DepartmentData 객체의 주소가 dd에 저장됨
		Department[] departments = dep.departments;	// DepartmentData 객체의 필드를 가져옴
		
		// 기초 데이터 생성
		//initData(departments);
		
		// 학과 목록 출력
		printDepartment(departments);
		
		// 학과 코드가 "923"인 학과의 ID, name, offic 출력
		getDepartment(departments);
		
		// 컴퓨터공학과의 교실을 반환하여 출력
		String strOffic = getOffice(departments);
		System.out.println(strOffic);
	}

	// 기초 데이터 생성 메소드
	private static void initData(Department[] departments) {
		departments[0] = new Department(920, "컴퓨터공학과", "201호");
		departments[1] = new Department(923, "산업공학과", "207호");
		departments[2] = new Department(925, "전자공학과", "308호");
		
	}

	// 학과 목록 출력 메소드
	private static void printDepartment(Department[] departments) {
		System.out.println("[학과 클래스]");
		System.out.println("ID\t이름\t\t교실");
		for (Department department : departments) {
			System.out.println(department.getId() + "\t" + department.getName() + "    \t" + department.getOffice());
		}
		System.out.println();
	}
	
	// 학과 코드가 "923"인 학과의 ID, name, offic 출력 메소드
	private static void getDepartment(Department[] departments) {
		System.out.println("[학과 코드가 \"923\"인 학과의 ID, name, offic 출력]");
		for (Department department : departments) {
			if (department.getId() == 923) {
				System.out.printf("ID : %d\t이름 : %s\t교실 : %s\n", department.getId(), department.getName(), department.getOffice());
			}
		}
		System.out.println();
	}
	
	// 컴퓨터공학과 교실 반환 메소드
	private static String getOffice(Department[] departments) {
		System.out.println("[컴퓨터공학과의 교실]");
		String arrName = "";
		for (Department department : departments) {
			if (department.getName().equals("컴퓨터공학과")) {
				arrName += department.getOffice();
			}
		}
		return arrName;
	}
}
