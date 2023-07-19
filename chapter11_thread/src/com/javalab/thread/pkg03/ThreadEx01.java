package com.javalab.thread.pkg03;

public class ThreadEx01 {

	public static void main(String[] args) {

		ThreadEx1_1 t1 = new ThreadEx1_1();	// 첫 번째 스레드 객체 생성 (상속)
		
		Runnable r = new ThreadEx1_2();		// 두 번째 스레드 객체 생성 (인터페이스)
		Thread t2 = new Thread(r);	// 생성자 Thread(Runnable Target)
		
		t1.start();	// 스레드 이름 : Thread-0
		t2.start(); // 스레드 이름 : Thread-1
	}

}

/**
 * Thread를 상속하는 스레드 클래스
 */
class ThreadEx1_1 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(this.getName());	// 조상인 Thread의 getName() 호출
		}
	}
}

/**
 * Runnable을 구현한 구현 클래스를 통한 스레드
 */
class ThreadEx1_2 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);	// sleep은 static 메소드
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			// Thread를 상속받지 않아서 바로 사용하지 못함
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}