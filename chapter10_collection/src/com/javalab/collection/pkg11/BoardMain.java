package com.javalab.collection.pkg11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoardMain {

	public static void main(String[] args) {

		List<Board> board = new ArrayList<>();
		board.add(new Board(100, "객체 배열을 통하여 학생명단 평균점수 최고점수 최고점 학생을 출력하세요", "김정희", "2023.03.03", 84));
		board.add(new Board(101, "객체지향 프로그래밍 - 인스턴스 멤버와 정적멤버", "최윤희", "2021.07.21", 99));
		board.add(new Board(102, "클래스와 객체지향 프로그래밍(Object Oriented Programming)", "우성민", "2020.06.10", 264));
		board.add(new Board(103, "[정렬] 선택 정렬(Selection Sort)", "정민태", "2023.01.02", 77));
		board.add(new Board(104, "Math.random() 메소드를 통한 난수 발생시키기", "김갑철", "2022.10.12", 94));
		board.add(new Board(105, "배열을 통한 사원 정보 관리 #2", "이수영", "2021.07.25", 70));
		board.add(new Board(106, "배열을 통한 학생 정보 관리 #1", "박영준", "2023.02.01", 80));
		board.add(new Board(107, "문자열(장문) 처리하기", "성수정", "2019.12.30", 56));
		board.add(new Board(108, "[과제] 주말과제 - 최고 점수와 최고 점수 학생명 구하기", "홍세나", "2020.05.17", 84));
		board.add(new Board(109, "[모듈화] 최고 점수와 최고 점수 학생명 구하기", "홍세나", "2023.03.03", 64));
		board.add(new Board(110, "다차원 배열 자료 저장 구조와 인덱스", "서동욱", "2022.07.010", 94));
		board.add(new Board(111, "제어문 반복문", "정연남", "2022.08.03", 84));
		board.add(new Board(112, "연산자(Operator)", "최정빈", "2020.01.01", 64));
		board.add(new Board(113, "키보드를 통해서 데이터 읽어들이기", "오민희", "2022.09.12", 984));
		board.add(new Board(114, "변수와 자료형 #1", "이의정", "2022.09.03", 164));

		// 1. 기본데이터를 Board 객체로 생성한 후에 ArrayList에 추가(add)하고 출력해주는 메소드를 만드세요.
		printAllBoard(board);

		// 2. 게시물 중에서 우성민, 홍세나가 작성한 게시물을 찾아서 반환해주는 메소드를 만드세요.
		getBoardByName(board);

		// 3. 배열과 관련된 게시물을 출력해주는 메소드를 만드세요.
		printBoard(board);

		// 4. 조회수가 가장 큰 게시물을 출력해주는 메소드를 만드세요.
		printHitCountBoard(board);

		// 5. 게시물 객체를 Set 컬렉션에 저장하고 출력해주는 메소드를 만드세요.
		printSetBoard(board);
		
		// 6. 게시물번호를 키(key)로 하여 HashMap에 학생 객체를 저장하고 출력해주는 메소드를 통해서 출력하세요.
		printMapBoard(board);
	}

	// 1. 기본데이터를 Board 객체로 생성한 후에 ArrayList에 추가(add)하고 출력해주는 메소드를 만드세요.
	private static void printAllBoard(List<Board> board) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("1. 기본데이터를 Board 객체로 생성한 후에 ArrayList에 추가(add)하고 출력해주는 메소드를 만드세요.");
		System.out.println("(1) 일반 for문");
		for (int i = 0; i < board.size(); i++) {
			System.out.println(board.get(i).getId() + "\t" + board.get(i).getTitle() + "\t" + board.get(i).getWriter()
					+ "\t" + board.get(i).getDate() + "\t" + board.get(i).getHitcount());
		}
		System.out.println();
		System.out.println("(2) 향상된 for문");
		for (Board board2 : board) {
			System.out.println(board2.getId() + "\t" + board2.getTitle() + "\t" + board2.getWriter() + "\t"
					+ board2.getDate() + "\t" + board2.getHitcount());
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
	}

	// 2. 게시물 중에서 우성민, 홍세나가 작성한 게시물을 찾아서 반환해주는 메소드를 만드세요.
	private static void getBoardByName(List<Board> board) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("2. 게시물 중에서 우성민, 홍세나가 작성한 게시물을 찾아서 반환해주는 메소드를 만드세요.");
		List<Board> getBoards = new ArrayList<Board>();
		for (Board b : board) {
			if (b.getWriter().equals("우성민") || b.getWriter().equals("홍세나")) {
				getBoards.add(b);
				System.out.println(b.getId() + "\t" + b.getTitle() + "\t" + b.getWriter() + "\t" + b.getDate() + "\t"
						+ b.getHitcount());
			}
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

	// 3. 배열과 관련된 게시물을 출력해주는 메소드를 만드세요.
	private static void printBoard(List<Board> board) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("3. 배열과 관련된 게시물을 출력해주는 메소드를 만드세요.");
		for (Board b : board) {
			if (b.getTitle().contains("배열")) {
				System.out.println(b.getId() + "\t" + b.getTitle() + "\t" + b.getWriter() + "\t" + b.getDate() + "\t"
						+ b.getHitcount());
			}
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

	// 4. 조회수가 가장 큰 게시물을 출력해주는 메소드를 만드세요.
	private static void printHitCountBoard(List<Board> board) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("4. 조회수가 가장 큰 게시물을 출력해주는 메소드를 만드세요.");
		int maxCount = 0;
		for (Board b : board) {
			if (b.getHitcount() > maxCount) {
				maxCount = b.getHitcount();
			}
		}
		System.out.println("찾아진 인덱스  : " + maxCount);
		for (Board b2 : board) {
			if (b2.getHitcount() == maxCount) {
				System.out.println(b2.getId() + "\t" + b2.getTitle() + "\t" + b2.getWriter() + "\t" + b2.getDate()
						+ "\t" + b2.getHitcount());
			}
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println();
	}
	
	// 5. 게시물 객체를 Set 컬렉션에 저장하고 출력해주는 메소드를 만드세요.
	private static void printSetBoard(List<Board> board) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("5. 게시물 객체를 Set 컬렉션에 저장하고 출력해주는 메소드를 만드세요.");
		HashSet<Board> setBoard = new HashSet<>();
		for (Board b : board) {
			setBoard.add(b);
		}
		for (Board b2 : setBoard) {
			System.out.println(b2.getId() + "\t" + b2.getTitle() + "\t" + b2.getWriter() + "\t" + b2.getDate() + "\t"
					+ b2.getHitcount());
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println();
	}
	
	// 6. 게시물번호를 키(key)로 하여 HashMap에 학생 객체를 저장하고 출력해주는 메소드를 통해서 출력하세요.
		private static void printMapBoard(List<Board> board) {
			Map<Integer, Board> mapBoard = new HashMap<>();
			mapBoard.put(100, new Board(100,"객체 배열을 통하여 학생명단 평균점수 최고점수 최고점 학생을 출력하세요", "김정희", "2023.03.03", 84));
			mapBoard.put(101, new Board(101,"객체지향 프로그래밍 - 인스턴스 멤버와 정적멤버", "최윤희", "2021.07.21", 99));
			mapBoard.put(102, new Board(102,"클래스와 객체지향 프로그래밍(Object Oriented Programming)", "우성민", "2020.06.10", 264));
			mapBoard.put(103, new Board(103,"[정렬] 선택 정렬(Selection Sort)", "정민태", "2023.01.02", 77));
			mapBoard.put(104, new Board(104,"Math.random() 메소드를 통한 난수 발생시키기", "김갑철", "2022.10.12", 94));
			mapBoard.put(105, new Board(105,"배열을 통한 사원 정보 관리 #2", "이수영", "2021.07.25", 70));
			mapBoard.put(106, new Board(106,"배열을 통한 학생 정보 관리 #1", "박영준", "2023.02.01", 80));
			mapBoard.put(107, new Board(107,"문자열(장문) 처리하기", "성수정", "2019.12.30", 56));
			mapBoard.put(108, new Board(108,"[과제] 주말과제 - 최고 점수와 최고 점수 학생명 구하기", "홍세나", "2020.05.17", 84));
			mapBoard.put(109, new Board(109,"[모듈화] 최고 점수와 최고 점수 학생명 구하기", "홍세나", "2023.03.03", 64));
			mapBoard.put(110, new Board(110,"다차원 배열 자료 저장 구조와 인덱스", "서동욱", "2022.07.010", 94));
			mapBoard.put(111, new Board(111,"제어문 반복문", "정연남", "2022.08.03", 84));
			mapBoard.put(112, new Board(112,"연산자(Operator)", "최정빈", "2020.01.01", 64));
			mapBoard.put(113, new Board(113,"키보드를 통해서 데이터 읽어들이기", "오민희", "2022.09.12", 984));
			mapBoard.put(114, new Board(114,"변수와 자료형 #1", "이의정", "2022.09.03", 164));
			
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("6. 게시물번호를 키(key)로 하여 HashMap에 학생 객체를 저장하고 출력해주는 메소드를 통해서 출력하세요.");
			System.out.println("(1) 향상된 for문");
			for (Integer id : mapBoard.keySet()) {
				System.out.println(mapBoard.get(id).getId() + "\t" + mapBoard.get(id).getTitle() + "\t" + mapBoard.get(id).getWriter() + "\t"
						+ mapBoard.get(id).getDate() + "\t" + mapBoard.get(id).getDate() + "\t" + mapBoard.get(id).getHitcount());
			}
			System.out.println();
			
			System.out.println("(2) Iterator");
			Set<Integer> keySet = mapBoard.keySet();
		    Iterator<Integer> iter = keySet.iterator();
		    	while(iter.hasNext()) {
		    		Integer key = iter.next();
		    		Board keyBoard = mapBoard.get(key);
		    		System.out.printf("%d \t  %s \t %s \t %d \n", keyBoard.getId(), keyBoard.getTitle(), keyBoard.getWriter(), keyBoard.getHitcount());      
		      }

			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println();
		}
}
