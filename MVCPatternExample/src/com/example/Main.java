package com.example;

import com.example.controller.StudentController;
import com.example.model.Student;
import com.example.view.StudentView;
import com.example.gui.StudentManagementGUI;

public class Main {
    public static void main(String[] args) {
        Student model = new Student("John Doe", "12345", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        StudentManagementGUI gui = new StudentManagementGUI(controller);
        gui.setVisible(true);
    }
}
