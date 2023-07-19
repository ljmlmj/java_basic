package com.javalab.collection.pkg10;

import java.util.ArrayList;
import java.util.List;

public class Defined {

	public static void main(String[] args) {
		
		// [문제.1] 1,2,3,4,5,6,7,8,9,10 을 갖는 ArrayList를 생성하고 값을 출력하세요.
		System.out.println("[문제.1] 1,2,3,4,5,6,7,8,9,10 을 갖는 ArrayList를 생성하고 값을 출력하세요.");
		List<Integer> iList = new ArrayList<>();
		iList.add(new Integer(1));
		iList.add(new Integer(2));
		iList.add(new Integer(3));
		iList.add(new Integer(4));
		iList.add(new Integer(5));
		iList.add(new Integer(6));
		iList.add(new Integer(7));
		iList.add(new Integer(8));
		iList.add(new Integer(9));
		iList.add(new Integer(10));
		for (Integer integer : iList) {
			System.out.println(integer);
		}
		System.out.println();
		
		// [문제.2] 다음 값을 갖는 ArrayList를 생성하고 값을 출력하세요.
		System.out.println("[문제.2] 다음 값을 갖는 ArrayList를 생성하고 값을 출력하세요.");
		List<String> sList = new ArrayList<>();
		sList.add(new String("Volvo"));
		sList.add(new String("Benz"));
		sList.add(new String("BMW"));
		sList.add(new String("Hyndai"));
		for (String string : sList) {
			System.out.println(string);
		}
		System.out.println();
		
		// [문제.3] 다음 raw data를 담을 수 있는 Student 클래스를 설계하고 객체를 생성하여 ArrayList에 담고 출력하세요.
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1234", "123456-1234567", "홍길동", 3, "천안", 210));
		students.add(new Student("5678", "987456-2334567", "김길동", 4, "대전", 220));
		students.add(new Student("8970", "357556-2334789", "이길동", 1, "서울", 230));
		for (Student student2 : students) {
			System.out.println(student2.toString());
		}
		System.out.println();
		
		// [문제.4] Member 클래스를 설계하세요. main 메소드에서 Member 객체를 담을 수 있는 ArrayList를 만드세요.
		String[] member = new String[10];
		member[0]="임재,20190509,20190510,8,남,30대후반";
		member[1]="성열,20190509,20190510,1,남,30대중반";
		member[2]="천재,20190509,20190510,3,남,30대초반";
		member[3]="현수,20190509,20190510,1,남,20대후반";
		member[4]="진우,20190509,20190510,2,남,30대초반";
		member[5]="영수,20190509,20190510,2,여,40대후반";
		member[6]="종화,20190509,20190510,0,남,20대후반";
		member[7]="윤정,20190509,20190510,3,여,40대후반";
		member[8]="종호,20190509,20190510,3,남,20대중반";
		member[9]="동현,20190509,20190510,5,남,20대중반";
		
		// 1. 기본데이터를 가공하여 Member 객체로 만들고 저장할 ArrayList 생성
		ArrayList<Member> memberList = new ArrayList<>();
		
		// 기본 데이터를 반복문을 통해서 Member 객체로 생성
		for (int i = 0; i < member.length; i++) {
			String[] arr = member[i].split(",");
			int numVisit = Integer.parseInt(arr[3]);
			char gender = arr[4].charAt(0);
			memberList.add(new Member(arr[0], arr[1], arr[2], numVisit, gender, arr[5]));
		}
		
		// 2. 이름이 "천재"인 회원을 찾고 별도의 메소드를 통해서 해당 회원을 출력하세요.
		findName(memberList);
		
		// 3. 전체 회원을 출력해주는 메소드
		printAllMembers(memberList);
		
		// 4. 30대인 회원들을 찾아주는 메소드를 만들고 ArrayList에 담아서 반환받고 출력하세요.
		ArrayList<Member> members = getMember30(memberList);
		for (Member member2 : members) {
			System.out.println(member2.toString());
		}
		
		// 5. 20대 후반들의 방문 횟수를 구해주는 메소드를 만들어서 값을 반환받고 출력하세요.
		System.out.println("20대 후반들의 방문 횟수 총합 : " + getVisit20(memberList));
	}
	
	// 20대 후반의 방문 횟수 총합 구하는 메소드
	private static int getVisit20(ArrayList<Member> memberList) {
		int count = 0;
		for (Member member : memberList) {
			if (member.getAge().equals("20대후반")) {
				count += member.getNumVisit();
			}
		}
		System.out.println();
		return count;
	}

	// 30대인 회원들을 찾아주는 메소드
	private static ArrayList<Member> getMember30(ArrayList<Member> memberList) {
		ArrayList<Member> members = new ArrayList<Member>();
		for (Member member : memberList) {
			if (member.getAge().contains("30대")) {
				members.add(member);
			}
		}
		return members;
	}

	// 전체 회원을 출력해주는 메소드
	private static void printAllMembers(List<Member> memberList) {
		System.out.println("전체 회원 출력");
		for (Member member : memberList) {
			System.out.println(member.toString());
		}
		System.out.println();
	}

	// 이름이 "천재"인 회원을 찾고 출력하는 메소드
	private static void findName(List<Member> memberList) {
		System.out.println("이름이 \"천재\"인 회원을 찾고 별도의 메소드를 통해서 해당 회원을 출력하세요.");
		for (Member mem : memberList) {
			if (mem.getName().equals("천재")) {
				System.out.println(mem.toString());
			}
		}
		System.out.println();
	}

}
