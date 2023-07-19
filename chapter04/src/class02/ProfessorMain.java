package class02;

public class ProfessorMain {

	public static void main(String[] args) {
		
		Professor[] professors = new Professor[6];
		professors[0] = new Professor("92001", "590327-1839240", "이태규", 920, "교수", "1997");
		professors[1] = new Professor("92002", "690702-1350026", "고희석", 910, "부교수", "2003");
		professors[2] = new Professor("92301", "741011-2765501", "최성희", 910, "부교수", "2005");
		professors[3] = new Professor("92302", "750728-1102458", "김태석", 920, "교수", "1999");
		professors[4] = new Professor("92501", "620505-1200546", "박철재", 900, "조교수", "2007");
		professors[5] = new Professor("92502", "740101-1830264", "장민석", 910, "부교수", "2005");
		
		
		// 교수들의 목록을 출력해주는 메소드
		printProfessor(professors);
		System.out.println();
		
		// 910 학과 교수 중 입사년도가 2005년인 교수
		getHireDate2005(professors);
		System.out.println();
		
		// 주민번호가 590327-1839240인 이태규 교수가 퇴직했다.
		// 새로 입사한 선명규 교수를 그 자리에 저장하세요.
		// (빈 객체 생성 후 setter 메소드로 값 저장)
		// "96031", "790208-1884203", "선명규", 920, "부교수", "2021"
		newProfessor(professors);
		System.out.println();
		
		
		
	}

	// 교수들의 목록을 출력해주는 메소드
	private static void printProfessor(Professor[] professors) {
		System.out.println("[Professor raw Data]");
		System.out.println("교수ID\t주민번호\t\t성명\t학과\tgrade\t입사일자");
		for (Professor prof : professors) {
			System.out.println(prof.getId() + "\t" + prof.getJumin() + "\t" + prof.getName() + "\t"
						+ prof.getDepartment() + "\t" + prof.getGrade() + "\t" + prof.getHiredate());
		}
	}

	// 910 학과 교수 중 입사년도가 2005년인 교수 출력하는 메소드
	private static void getHireDate2005(Professor[] 
			professors) {
		System.out.print("901 학과 교수 중 입사년도가 2005년인 교수 : ");
		for (Professor prof : professors) {
			if (prof.getDepartment() == 910 && prof.getHiredate().contains("2005")) {
					System.out.print(prof.getName() + "  ");
			}
		}
	}
	
	// 주민번호가 590327-1839240인 이태규 교수가 퇴직했다.
	// 새로 입사한 선명규 교수를 그 자리에 저장하세요.
	// (빈 객체 생성 후 setter 메소드로 값 저장)
	// "96031", "790208-1884203", "선명규", 920, "부교수", "2021"
	private static void newProfessor(Professor[] professors) {
		
		
		for (int i = 0; i < professors.length; i++) {
			if(professors[i].getName().equals("이태규") && professors[i].getJumin().equals("590327-1839240")) {
				Professor professor = new Professor();
				
				professor.setId("96031");
				professor.setJumin("790208-1884203");
				professor.setName("선명규");
				professor.setDepartment(920);
				professor.setGrade("부교수");
				professor.setHiredate("2021");
				professors[i] = professor;
			}
		}
		printProfessor(professors);		
	}
	
}
