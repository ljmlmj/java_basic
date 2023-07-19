package com.javalab.awt.menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentForm extends JFrame {

    private ArrayList<Student> studentList;

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField;
    private JTextField juminField;
    private JTextField nameField;
    private JTextField yearField;
    private JTextField addressField;
    private JTextField departmentField;

    public StudentForm() {
        // Initialize the student list
        studentList = new ArrayList<>();

        // Set up the table
        String[] columnNames = {"ID", "주민등록번호", "이름", "학년", "주소", "학과"};
        Object[][] data = new Object[0][6];
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Set up the input fields and labels
        idField = new JTextField(10);
        juminField = new JTextField(10);
        nameField = new JTextField(10);
        yearField = new JTextField(10);
        addressField = new JTextField(10);
        departmentField = new JTextField(10);

        JLabel idLabel = new JLabel("학번:");
        JLabel juminLabel = new JLabel("주민등록번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel yearLabel = new JLabel("학년:");
        JLabel addressLabel = new JLabel("주소:");
        JLabel departmentLabel = new JLabel("학과:");

        // Set up the button to add a new student
        JButton addButton = new JButton("추가");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String jumin = juminField.getText();
                String name = nameField.getText();
                int year = Integer.parseInt(yearField.getText());
                String address = addressField.getText();
                int department = Integer.parseInt(departmentField.getText());

                Student student = new Student(id, jumin, name, year, address, department);
                studentList.add(student);

                // Update the table model
                Object[] row = {id, jumin, name, year, address, department};
                tableModel.addRow(row);

                // Clear the input fields
                idField.setText("");
                juminField.setText("");
                nameField.setText("");
                yearField.setText("");
                addressField.setText("");
                departmentField.setText("");
            }
        });

        // Set up the main panel with the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(juminLabel);
        inputPanel.add(juminField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(addButton, BorderLayout.EAST);

        // Set up the frame
        setTitle("학생 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new StudentForm();
    }
}
