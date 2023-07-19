package com.javalab.fileio.pkg06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * 객체를 파일에 저장하는 예제
 * 	- 객체를 파일에 쓸 때는 직렬화를 하고
 * 	- 파일에 써진 객체를 읽어올 때는 역직렬화를 한다.
 * 	- 이 때 필요한 것이 직렬화된 객체와 역직렬화된 객체가 같은 타입이냐가 중요하다.
 * 	     그래서 serialVersionUID 필드가 필요하다.
 */
public class ObjectInOutStreamExam02 {

	public static void main(String[] args) throws Exception {
		
		// 파일을 다룰 파일 객체 생성 (파일의 경로 전달)
		File file = new File("C:/filetest/object.txt");
		// FileOutputStream 객체 생성
		FileOutputStream fos = new FileOutputStream(file);
		// FileOutputStream에 ObjectOutputStream 보조 스트림 연결
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// Member, Product, int type 배열 객체 생성
		Member member = new Member("fail", "단풍이");
		Product product = new Product("노트북", 150000);
		int[] arr1 = {1, 2, 3};
		
		// 객체를 직렬화해서 파일에 저장(객체의 필드를 바이트 형태로 변환해서 저장
		oos.writeObject(member);
		oos.writeObject(product);
		oos.writeObject(arr1);
		
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/filetest/object.txt");
		// FileInputStream에 ObjectInputStream 보조 스트림 연결
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 파일을 읽고 역직렬화해서 객체로 복원
		// byte 형태로 파일에 저장해놓은 객체를 다시 불러들여서 자바 객체 형태로 복원
		Member member2 = (Member) ois.readObject();
		Product product2 = (Product) ois.readObject();
		int[] arr2 = (int[]) ois.readObject();
		
		ois.close();
		fis.close();
		
		// 복원된 객체 내용 확인
		System.out.println(member2);
		System.out.println(product2);
		System.out.println(Arrays.toString(arr2));
	}

}
