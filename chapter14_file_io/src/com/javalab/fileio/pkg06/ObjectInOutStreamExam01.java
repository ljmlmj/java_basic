package com.javalab.fileio.pkg06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ObjectOutputStream
 * 	- 개발자가 만든 클래스의 인스턴스(객체)를 파일에 저장함.
 */

class Person implements Serializable {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class ObjectInOutStreamExam01 {

	public static void main(String[] args) throws ClassNotFoundException {
		// 파일에 저장할  Person 객체 생성
		Person person = new Person("John Doe", 30);
		File file = null;
		
		try {
			// 파일 객체 생성
			file = new File("C:/filetest/object2.txt");
			
			// 객체를 파일에 쓸 FileOutputStream 객체 생성
			FileOutputStream fos = new FileOutputStream(file);
			
			// FileOutputStream에 보조스트림인 ObjectOutputStream 연결
			ObjectOutputStream objOut = new ObjectOutputStream(fos);
			objOut.writeObject(person);
			objOut.close();
			
			System.out.println("객체가 정상적으로 파일에 써졌습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. 파일에서 객체 읽어들이기
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			// Object() 메소드의 반환타입이 Object이기 때문에 형 변환
			Person savedPerson = (Person) objectIn.readObject();
			objectIn.close();
			
			System.out.println("객체를 파일에서 읽어들임");
			System.out.println(savedPerson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
