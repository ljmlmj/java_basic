package com.javalab.awt.pkg10;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Table : 목록을 출력해주는 컴포넌트
 * ArrayList<Stduent> studentList를 JTable 컴포넌트를 통해서 출력하는 방법
 */
public class StudentTableExample {

	private JFrame frame;
	
	public StudentTableExample() {
		frame = new JFrame("Student Table Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("001", "123-45-6789", "John Smith", 3, "123 Main St.", 1));
		studentList.add(new Student("002", "234-56-7890", "Jane Doe", 2, "456 Park Ave.", 2));
		studentList.add(new Student("003", "345-67-8901", "Bob Johnson", 4, "789 Elm St.", 1));
		
		// 제목
		String[] columnNames = {"ID", "Jumin", "Name", "Year", "Address", "Department"};
		
		// 행의 갯수는 몇개가 될 지 알 수 없기 때문에 ArrayList의 사이즈를 갖고와서 배열 생성
		Object[][] data = new Object[studentList.size()][6];
		int i = 0;
		for (Student student : studentList) {
			data[i][0] = student.getId();
			data[i][1] = student.getJumin();
			data[i][2] = student.getName();
			data[i][3] = student.getYear();
			data[i][4] = student.getAddress();
			data[i][5] = student.getDepartment();
			i++;
		}
		
		/**
		 * Swing에서 DefaultTableModel은 테이블의 데이터 구조를 정의하는 데에
		 * 사용되는 TableModel 인텉페이스의 기본 구현을 제공하는 클래스입니다.
		 * 행과 열을 추가하거나 제거하고 개별 셀에서 값을 가져오고 설정하는 등 테이블의
		 * 데이터를 조작하는 메소드를 제공합니다.
		 */
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		// 데이터를 JTable 형태로 표현해주는 객체
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		// 스크롤 패널을 프레임의 Root 패널에 부착
		frame.setContentPane(scrollPane);
		// 스크롤 패널이 프레임의 크기에 맞춰서 보여지도록 설정해줌
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new StudentTableExample();
	}
	
	private static class Student {
        private String id;
        private String jumin;
        private String name;
        private int year;
        private String address;
        private int department;

        public Student(String id, String jumin, String name, int year, String address, int department) {
            this.id = id;
            this.jumin = jumin;
            this.name = name;
            this.year = year;
            this.address = address;
            this.department = department;
        }

        public String getId() {
            return id;
        }

        public String getJumin() {
            return jumin;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getAddress() {
            return address;
        }

        public int getDepartment() {
            return department;
        }
	}
}
