package com.javalab.stream04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.javalab.stream03.Student;

/**
 * 스트림 반복문, ampToInt() 중간연산 메소드
 */
public class MapToIntEx02 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 90));
		list.add(new Student("신용권", 92));
		list.add(new Student("유미선", 100));
		
		Stream<Student> studentStream = list.stream();
		
		// 중간 연산 메소드인 mapToInt
		//	- student 객체의 int type 변수의 값만 모아서 IntStream 반환
		IntStream scoresStream = studentStream
											//.mapToInt(Student :: getScore)
											  .mapToInt(student -> student.getScore());
		double avg = scoresStream.average().getAsDouble();
		
		double avg2 = list.stream()
				// [중간처리] 학생 객체를 점수로 매핑해서 score를 요소로 갖는 새로운 스트림 생성
				// 그 스트림이 IntStream 이다.
				// mapToInt는 함수형 인터페이스인 ToIntFunction타입을 매개변수로 갖고 IntStream을리턴해줌
						  .mapToInt(student -> student.getScore())
			    //		  .mapToInt(Stduent :: getScore)
				// 최종 처리 (평균 점수)
						  .average()	// score요소들의 평균을 계산해줌.
						  .getAsDouble();	// 평균을 Double 타입으로 얻어줌.
		
		System.out.println(avg);
		System.out.println(avg2);
	
	}

}
