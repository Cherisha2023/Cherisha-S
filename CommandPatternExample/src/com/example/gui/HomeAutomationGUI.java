package com.example.gui;

import com.example.command.LightOffCommand;
import com.example.command.LightOnCommand;
import com.example.invoker.RemoteControl;
import com.example.receiver.Light;

import javax.swing.*;
import java.awt.*;

public class HomeAutomationGUI extends JFrame {
    private JButton lightOnButton;
    private JButton lightOffButton;
    private Light light;
    private RemoteControl remoteControl;

    public HomeAutomationGUI() {
        setTitle("Home Automation System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));

        light = new Light();
        remoteControl = new RemoteControl();

        lightOnButton = new JButton("Turn On Light");
        lightOffButton = new JButton("Turn Off Light");

        lightOnButton.addActionListener(e -> {
            remoteControl.setCommand(new LightOnCommand(light));
            remoteControl.pressButton();
        });

        lightOffButton.addActionListener(e -> {
            remoteControl.setCommand(new LightOffCommand(light));
            remoteControl.pressButton();
        });

        add(lightOnButton);
        add(lightOffButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeAutomationGUI homeAutomationGUI = new HomeAutomationGUI();
            homeAutomationGUI.setVisible(true);
        });
    }
}

