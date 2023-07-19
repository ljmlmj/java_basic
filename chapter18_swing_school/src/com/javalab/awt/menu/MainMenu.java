package com.javalab.awt.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 초기화면 - 메인 메뉴
 *  - 프로그램 구동후 가장 먼저 보여지는 화면
 *  - 여기에서 다른 화면으로 이동함.
 */
public class MainMenu extends JFrame implements ActionListener {
    // GUI components
    private JLabel titleLabel;
    private JButton studentButton;
    private JButton professorButton;
    private JButton departmentButton;
    private JButton takesButton;
    private JButton studentListButton;
    private JButton professorListButton;
    private JButton departmentListButton;
    private JButton takesListButton;
    private JButton exitButton;
    
    public MainMenu() {
        // Set up the GUI components
        setTitle("Registration Form");
        setLayout(new GridLayout(10, 1));
        setSize(300, 400);
        
        // Title label
        titleLabel = new JLabel("Select an option:");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
        
        // Student Register button
        studentButton = new JButton("Student Register");
        studentButton.addActionListener(this);
        add(studentButton);
        
        // Professor Register button
        professorButton = new JButton("Professor Register");
        professorButton.addActionListener(this);
        add(professorButton);
        
        // Department Register button
        departmentButton = new JButton("Department Register");
        departmentButton.addActionListener(this);
        add(departmentButton);
        
        // Takes Register button
        takesButton = new JButton("Takes Register");
        takesButton.addActionListener(this);
        add(takesButton);
        
        // Student List button
        studentListButton = new JButton("Student List");
        studentListButton.addActionListener(this);
        add(studentListButton);
        
        // Professor List button
        professorListButton = new JButton("Professor List");
        professorListButton.addActionListener(this);
        add(professorListButton);
        
        // Department List button
        departmentListButton = new JButton("Department List");
        departmentListButton.addActionListener(this);
        add(departmentListButton);
        
        // Takes List button
        takesListButton = new JButton("Takes List");
        takesListButton.addActionListener(this);
        add(takesListButton);
        
        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == studentButton) {
            System.out.println("Student Register");
            StudentForm studentForm = new StudentForm();	// 학생 등록폼 객체 생성
            studentForm.setVisible(true);					// 만든 학생 보이기
        } else if (e.getSource() == professorButton) {
            System.out.println("Professor Register");
            ProfessorForm professorForm = new ProfessorForm();
            professorForm.setVisible(true);            
        } else if (e.getSource() == departmentButton) {
            System.out.println("Department Register");
            DepartmentForm departmentForm = new DepartmentForm();
            departmentForm.setVisible(true);              
        } else if (e.getSource() == takesButton) {
            System.out.println("Takes Register");
            TakesForm takesForm = new TakesForm();
            takesForm.setVisible(true);             
        } else if (e.getSource() == studentListButton) {
            System.out.println("Student List");
            /////////// JTable로 구현 //////////
        } else if (e.getSource() == professorListButton) {
            System.out.println("Professor List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == departmentListButton) {
            System.out.println("Department List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == takesListButton) {
            System.out.println("Takes List");
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        MainMenu registerForm = new MainMenu();
    }
}