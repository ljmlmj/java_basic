package com.javalab.awt.pkg10;

import javax.swing.*;

public class Table01 {
	// 필드
	JFrame frame;
	
	// 생성자
	public Table01() {
		frame = new JFrame();
		
		// 테이블에 출력될 값
		String data[][] = 
			{
					{ "101", "Amit", "670000"},
					{ "102", "Jai", "780000"},
					{ "101", "Sachin", "700000"}
			};
		
		// 테이블에 출력될 제목
		String column[] = {"ID", "NAME", "SALARY"};
		
		// Table 객체 생성
		JTable table = new JTable(data, column);
		table.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(table);
		
		frame.add(sp);
		frame.setSize(300,400);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Table01();
	}
}
