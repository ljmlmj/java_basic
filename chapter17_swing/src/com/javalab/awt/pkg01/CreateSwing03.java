package com.javalab.awt.pkg01;

import javax.swing.*;
/**
 * JFrame 객체를 상속해서 만들기
 */
public class CreateSwing03 extends JFrame {
	// 필드
	JFrame frame;
	
	// 생성자
	
	public CreateSwing03 () {
		JButton b = new JButton("click"); 	// 버튼생성
		b.setBounds(130, 100, 100, 40);	// 버튼 위치와 크기 지정
		
		add(b);	// JFrame을 상속받았기 때문에 JFrame이 갖고 있는 add 메소드 바로 사용
		setSize(400,500);
		setLayout(null);
		setVisible(true);
	}
	
	// main 메소드에서 객체 생성
	public static void main(String[] args) {
		new CreateSwing03();	// CreateSwing02 메소드 호출
	}
}
