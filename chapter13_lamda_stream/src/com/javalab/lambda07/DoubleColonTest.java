package com.javalab.lambda07;

import java.util.Arrays;
import java.util.List;

/**
 * 이중 콜론(::) 연산자
 * 	- 람다식에서 파라미터를 중복해서 쓰기 싫을 때 사용
 * 	- http://younbumtae.com/?p=2776
 */
public class DoubleColonTest {

	public static void main(String[] args) {
		
		// 파라미터로 전달된 배열을 List<String>로 만들어줌.
		List<String> names = Arrays.asList("김갑순", "김갑돌");
		
		// x를 건네고 받는 과정에서 x를 두 번 적게 된다.
		names.forEach(x -> System.out.println(x));
		System.out.println();

		// 아예 x들을 빼버리고 아래와 같이 작설할 수 있다.
		names.forEach(System.out::println);
	}

}
