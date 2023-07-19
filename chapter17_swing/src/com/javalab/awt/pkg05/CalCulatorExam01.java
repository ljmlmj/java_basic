package com.javalab.awt.pkg05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Swing으로 사칙연산 계산기 프로그램 만들기
 */
public class CalCulatorExam01 extends JFrame implements ActionListener {
	private JTextField tf1, tf2, tf3;
	private JButton addBtn, subractBtn, multiplyBtn, divideBtn;
	
	public CalCulatorExam01() {
		super("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf1 = new JTextField(10);	// 입력 칸 객체 생성
		tf2 = new JTextField(10);
		tf3 = new JTextField(10);
		tf3.setEditable(false);	// 편집불가(결과창)
		
		addBtn = new JButton("+");
		subractBtn = new JButton("-");
		multiplyBtn = new JButton("*");
		divideBtn = new JButton("/");
		
		addBtn.addActionListener(this);
		subractBtn.addActionListener(this);
		multiplyBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		
		// 4행 3열의 그리드 레이아웃이 적용된 패널 생성
		// 칸을 나누고 순차적으로 하나의 컴포넌트를 추가해나간다.
		// 남는 칸은 빈칸으로 남아 있음.
		JPanel p = new JPanel(new GridLayout(5, 2));
		p.add(new JLabel("첫 번째 숫자 : "));
		p.add(tf1);
		p.add(new JLabel("두 번째 숫자 : "));
		p.add(tf2);
		p.add(new JLabel("연산 결과 : "));
		p.add(tf3);
		p.add(addBtn);
		p.add(subractBtn);
		p.add(multiplyBtn);
		p.add(divideBtn);
		
		// 컨텐츠 패널은 JFrame의 기본 컨테이너이며 프레임 내의 콘텐츠 및 구성 요소를 관리를 담당한다.
		// 프레임 > 메인 컨텐츠 패널 > 패널 > 컴포턴트(버튼,레이블,텍스트필드)
		setContentPane(p);
		pack();	// pack() 메소드는 패널에 맞게 크기가 적절하게 조정되도록 프레임에서 호출해줌
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new CalCulatorExam01();
	}
	
	// 액션 리스너(이벤트가ㅏ 발생했을 때 처리하는 메소드)
	@Override
	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(tf1.getText());
		double num2 = Double.parseDouble(tf2.getText());
		double result = 0;
		String operator = e.getActionCommand();
		
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default :
			break;
		}
		// setText : 텍스트 필드에는 문자열을 지정해야 함. String type
		tf3.setText(String.valueOf(result));
	}

}
