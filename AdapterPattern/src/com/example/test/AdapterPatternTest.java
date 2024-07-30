package com.example.test;

import com.example.adapter.PayPalAdapter;
import com.example.adapter.StripeAdapter;
import com.example.adaptee.PayPal;
import com.example.adaptee.Stripe;
import com.example.target.PaymentProcessor;

import java.util.Scanner;

public class AdapterPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        String amount = scanner.nextLine();

        System.out.print("Choose payment gateway (PayPal/Stripe): ");
        String gateway = scanner.nextLine();

        PaymentProcessor paymentProcessor;

        if (gateway.equalsIgnoreCase("PayPal")) {
            paymentProcessor = new PayPalAdapter(new PayPal());
        } else if (gateway.equalsIgnoreCase("Stripe")) {
            paymentProcessor = new StripeAdapter(new Stripe());
        } else {
            System.out.println("Invalid payment gateway selected.");
            return;
        }

        paymentProcessor.processPayment(amount);
    }
}

