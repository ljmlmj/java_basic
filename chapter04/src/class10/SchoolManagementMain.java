package class10;


import class10.vo.MakeData;
import class10.vo.Student;
import class10.vo.Department;
import class10.vo.Takes;
import class10.vo.Professor;

public class SchoolManagementMain {

	public static void main(String[] args) {

		MakeData makedata = new MakeData();
		Student[] students = makedata.students;
		Department[] departments = makedata.departments;
		Takes[] takes = makedata.takes;
		Professor[] professors = makedata.professors;
		
		
		// 학생배열의 학과코드와 학과배열의 학과코드를 이용하여 학생 데이터와 학과를 출력 
		System.out.println("학번\t이름\t주민\t\t학년\t학과코드\t학과");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < departments.length; j++) {
				if (students[i].getDepartment() == departments[j].getId()) {
					System.out.println(students[i].getId() + "\t" + students[i].getName() + "\t"
								+ students[i].getJumin() + "\t" + students[i].getYear() + "\t"
								+ students[i].getDepartment() + "\t" + departments[j].getName());
				}
			}
		}
		System.out.println();
		
		// 학생배열의 학번과 성적배열의 학번을 이용해서 학생데이터와 성적을 출력
		System.out.println("학번\t이름\t주민\t\t학년\t주소\t학과코드\t과목코드\t성적");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < takes.length; j++) {
				if (students[i].getId().equals(takes[j].getId())) {
					System.out.println(students[i].getId() + "\t" + students[i].getName() + "\t"
							+ students[i].getJumin() + "\t" + students[i].getYear() + "\t"
							+ students[i].getAddress() + "\t" + students[i].getDepartment() + "\t"
							+ takes[j].getSubject() + "\t" + takes[j].getScore());
				}
			}
		}
		System.out.println();
		
		/**
		 * 컴퓨터공학과 교수들을 모두 조회하세요.
		 * 1. 학과배열에서 컴퓨터공학과 코드 찾기
		 * 2. 코드로 교수 배열에 해당하는 교수 찾기
		 */
		
		System.out.println("[컴퓨터공학과 교수]");
		int code = 0;
		for (int i = 0; i < departments.length; i++) {
			if (departments[i].getName().equals("컴퓨터공학과")) {
				code = departments[i].getId();
			}
		}
		for (int j = 0; j < professors.length; j++) {
			if (code == professors[j].getDepartment()) {
				System.out.println(professors[j].getId() + "\t" + professors[j].getJumin() + "\t" 
						+ professors[j].getName() + "\t" + professors[j].getDepartment() + "\t" 
						+ professors[j].getHiredate() + "\t" + professors[j].getGrade());
				
			}
		}
		System.out.println();
	}
}
