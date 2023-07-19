package com.javalab.awt.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorForm extends JPanel implements ActionListener {

	private JLabel idLabel, juminLabel, nameLabel, departmentLabel, gradeLabel, hiredateLabel;
	private JTextField idField, juminField, nameField, departmentField, gradeField, hiredateField;
	private JButton submitButton;

	public ProfessorForm() {
		idLabel = new JLabel("ID:");
		idField = new JTextField(10);

		juminLabel = new JLabel("주민번호:");
		juminField = new JTextField(10);

		nameLabel = new JLabel("이름:");
		nameField = new JTextField(10);

		departmentLabel = new JLabel("학과:");
		departmentField = new JTextField(10);

		gradeLabel = new JLabel("직급:");
		gradeField = new JTextField(10);

		hiredateLabel = new JLabel("입사일자:");
		hiredateField = new JTextField(10);

		submitButton = new JButton("등록");
		submitButton.addActionListener(this);

		JPanel inputPanel = new JPanel(new GridLayout(7, 2));
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(juminLabel);
		inputPanel.add(juminField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(departmentLabel);
		inputPanel.add(departmentField);
		inputPanel.add(gradeLabel);
		inputPanel.add(gradeField);
		inputPanel.add(hiredateLabel);
		inputPanel.add(hiredateField);
		inputPanel.add(new JLabel());
		inputPanel.add(submitButton);

		add(inputPanel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			// 입력 필드 값을 사용하여 새 교수 개체 만들기
			Professor professor = new Professor();
			professor.setId(idField.getText());
			professor.setJumin(juminField.getText());
			professor.setName(nameField.getText());
			professor.setDepartment(Integer.parseInt(departmentField.getText()));
			professor.setGrade(gradeField.getText());
			professor.setHiredate(hiredateField.getText());

			// 교수 객체를 ArrayList 또는 데이터베이스 또는 파일에 추가
			// TODO: Add code to save the professor object to a database or file

			// 교수 객체 성공적으로 등록 완료 메시지
			JOptionPane.showMessageDialog(this, "교수 등록 완료.");

			// 입력 텍스트 필드 클리어
			idField.setText("");
			juminField.setText("");
			nameField.setText("");
			departmentField.setText("");
			gradeField.setText("");
			hiredateField.setText("");
		}
	}
}