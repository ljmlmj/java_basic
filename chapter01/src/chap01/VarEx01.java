package chap01;

public class VarEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 0;					// 변수 선언과 동시에 초기화 (변수 저장 공간 생성 -> 사용가능)
		int age = 14;					// 변수 선언과 동시에 초기화 (변수 저장 공간 생성 -> 사용가능)
		int tempVar;					// 변수 선언만 (실제로 변수 저장 공간 메모리에 생성 안됨 ->사용불가)
		
		System.out.println(year);
		System.out.println(age);
		// age = tempVar + 0; 			// 초기화 안된 상태에서 사용 불가
		year = age + 2000; 				// 변수 age의 값에 2000을 더해서 변수 year에 저장
		age = age + 1; 					// 변수 age에 저장된 값을 1 증가시킨다.
		tempVar = age; 					// 변수의 값을 복사할 수 있다. (변수 초기화되면서 생성됨)
		
		System.out.println(year);
		System.out.println(age);
		System.out.println(tempVar);	// 변수가 생성되었기 때문에 사용가능
		
	}

}
