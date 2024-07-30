package com.example.test;

import com.example.component.EmailNotifier;
import com.example.component.Notifier;
import com.example.decorator.SMSNotifierDecorator;
import com.example.decorator.SlackNotifierDecorator;

import java.util.Scanner;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter notification message: ");
        String message = scanner.nextLine();

        System.out.print("Send via (Email/SMS/Slack): ");
        String channels = scanner.nextLine();

        Notifier notifier = new EmailNotifier(); // Base notifier

        if (channels.toLowerCase().contains("sms")) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        if (channels.toLowerCase().contains("slack")) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        notifier.send(message);
    }
}

