package com.javalab.awt.pkg03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JTextField;

/**
 * 버튼 액션 리스너(이벤트 핸들러)
 * JFrame을 상속받고 ActionListener을 구현함.
 * 	-https://www.javatpoint.com/java-jlabel
 * 	- 생성자에서 레이블 관련 설정, 이벤트 핸들러 설정
 */
public class ImplementAction extends JFrame implements ActionListener{
	// 필드
	JTextField tf;		// 텍스트 필드
	JLabel labelObj;	// 레이블 필드
	JButton buttonObj;	// 버튼 필드
	
	// 생성자
	public ImplementAction() {
		tf = new JTextField();		// 텍스트 필드 객체 생성
		tf.setBounds(50,50,150,20);
		
		labelObj = new JLabel();		// 레이블 객체 생성
		labelObj.setBounds(50,100,250,20);
		
		buttonObj = new JButton("Find IP");	// 버튼 객체 생성
		buttonObj.setBounds(50,150,95,30);
		
		/**
		 * 버튼 액션 리스너(이벤트 핸들러) 부착
		 * 	- 익명 구현 객체로 만들지 않고 별도의 메소드로 분리
		 * 	- 별도로 분리된 actionPerformed() 메소드 호출
		 * 	- this : 파라미터로 자기 자신을 전달함
		 */
		buttonObj.addActionListener(this);
		
		// JFrame을 상속 받았으므로 add()메소드 바로 사용
		add(buttonObj);
		add(tf);
		add(labelObj);
		
		setSize(400,400);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImplementAction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("여기는 이벤트 핸들러");
			String host = tf.getText();
			String ip = java.net.InetAddress.getByName(host).getHostAddress();
			labelObj.setText("IP of " + host + " is " + ip);
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
	}
}
