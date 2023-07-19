package com.javalab.collection.pkg04;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		// HashSet 객체 생성
		HashSet<Member> members = new HashSet<>();
		
		// HashSet에 Member 객체 추가
		members.add(new Member("Aclice", 30));
		members.add(new Member("Bob", 35));
		members.add(new Member("Charlie", 40));
		members.add(new Member("David", 45));
		
		// HashSet 객체 생성
		HashSet<Member> members2 = new HashSet<>();
		
		// HashSet에 Member 객체 추가
		members2.add(new Member("Aclice", 30));
		members2.add(new Member("Bob", 35));
		members2.add(new Member("Charlie", 40));
		members2.add(new Member("David", 45));
		
		// 위의 두 HashSet의 내용 비교
		if (members.equals(members2)) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
	}
}
