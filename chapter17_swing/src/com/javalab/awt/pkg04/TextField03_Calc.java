package com.javalab.awt.pkg04;

import javax.swing.*;
import java.awt.event.*;

/**
 * 텍슽트 필드와 버튼을 사용한 초간단 계산기
 */
public class TextField03_Calc implements ActionListener {
	JTextField tf1, tf2, tf3;	// 두 칸은 입력칸, 한 칸은 출력
	JButton b1, b2;				// +, - 버튼
	
	// 기본 생성자
	public TextField03_Calc() {
		JFrame f = new JFrame();	// 프레임 생성
		
		tf1 = new JTextField();
		tf1.setBounds(50, 50, 150, 20);
		
		tf2 = new JTextField();
		tf2.setBounds(50,100,150,20);
		
		tf3 = new JTextField();
		tf3.setBounds(50,150,150,20);
		tf3.setEditable(false);		// 입력불가(결과만 보여줄 텍스트필드이기 때문에)
		
		b1 = new JButton("+");
		b1.setBounds(50,200,50,50);
		
		b2 = new JButton("-");
		b2.setBounds(120,200,50,50);
		
		/**
		 * 이벤트 핸들러 호출
		 * 	- 액션 리스너 호출 시 객체 자신 전달 (전달 시 각각 클릭된 버튼 자신이 전달됨)
		 */
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b1);
		f.add(b2);
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	// 액션 리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭 이벤트 발생");
		String s1 = tf1.getText();	// 텍스트 필드의 입력 값
		String s2 = tf2.getText();	// 텍스트 필드의 입력 값
		
		int a = Integer.parseInt(s1);	// 입력 값을 int로 변환
		int b = Integer.parseInt(s2);	// 입력 값을 int로 변환
		int c = 0;
		
		if (e.getSource() == b1) {		// e.getSource() : 클린된 자원이 누구냐?
			c = a + b;
		} else if (e.getSource() == b2) {
			c = a - b;
		}
		String result = String.valueOf(c);
		tf3.setText(result);
	}
	
	public static void main(String[] args) {
		new TextField03_Calc();
	}
}
