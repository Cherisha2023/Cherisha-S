package com.example.gui;

import com.example.controller.StudentController;
import com.example.model.Student;
import com.example.view.StudentView;

import javax.swing.*;
import java.awt.*;

public class StudentManagementGUI extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JTextField gradeField;
    private JButton updateButton;
    private JTextArea displayArea;

    private StudentController controller;

    public StudentManagementGUI(StudentController controller) {
        this.controller = controller;

        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Grade:"));
        gradeField = new JTextField();
        add(gradeField);

        updateButton = new JButton("Update");
        add(updateButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        updateButton.addActionListener(e -> updateStudent());

        setVisible(true);
    }

    private void updateStudent() {
        controller.setStudentName(nameField.getText());
        controller.setStudentId(idField.getText());
        controller.setStudentGrade(gradeField.getText());

        controller.updateView();

        displayArea.setText("Student Details:\n" +
                "Name: " + controller.getStudentName() + "\n" +
                "ID: " + controller.getStudentId() + "\n" +
                "Grade: " + controller.getStudentGrade());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Student model = new Student("John Doe", "12345", "A");
            StudentView view = new StudentView();
            StudentController controller = new StudentController(model, view);
            new StudentManagementGUI(controller);
        });
    }
}

