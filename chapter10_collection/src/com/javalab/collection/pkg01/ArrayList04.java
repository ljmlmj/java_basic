package com.javalab.collection.pkg01;

import java.util.ArrayList;
import java.util.List;

/* 	[Raw Data]
	"제목1", "내용1", "글쓴이1"
	"제목2", "내용2", "글쓴이2"
	"제목3", "내용3", "글쓴이3"
	"제목4", "내용4", "글쓴이4"
	"제목5", "내용5", "글쓴이5"
*/
public class ArrayList04 {

	public static void main(String[] args) {
		// ArrayList 컬렉션 생성
		List<Board> list = new ArrayList<>();
		
		// 객체 추가
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		// 저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		// 2번째 인덱스의 객체 가져와서 출력하기
		Board secIdx = list.get(2);
		System.out.println("2번째 인덱스 값 : " + secIdx.toString());
		System.out.println();
		
		// 모든 객체를 하나씩 가져오기
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
		}
		System.out.println();
		
		// 객체 삭제
		list.remove(2);
		list.remove(2);
		
		// 향상된 for문으로 모든 객체를 하나씩 가져오기
		for (Board b : list) {
			System.out.println(b.toString());
		}
		System.out.println();
		
		// "제목11", "내용11", "글쓴이11" <- list 인덱스 1번에 넣으세요.
		list.set(1, new Board("제목11", "내용11", "글쓴이11"));
		for (Board board : list) {
			System.out.println(board.toString());
		}
		System.out.println();
	}
}

class Board {
	private String subject;
	private String content;
	private String writer;
	
	public Board() {
	}
	
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Board [subject=" + subject + ", content=" + content + ", writer=" + writer + "]";
	}
	
}