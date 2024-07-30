package com.example.gui;

import com.example.context.PaymentContext;
import com.example.strategy.CreditCardPayment;
import com.example.strategy.PayPalPayment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentSystemGUI extends JFrame {
    private JTextField amountField;
    private JComboBox<String> paymentMethodCombo;
    private JButton payButton;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JTextField ccNumberField, ccHolderField, ccCVVField, ccExpiryField;
    private JTextField ppEmailField, ppPasswordField;

    public PaymentSystemGUI() {
        setTitle("Payment System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        String[] paymentMethods = {"Credit Card", "PayPal"};
        paymentMethodCombo = new JComboBox<>(paymentMethods);
        paymentMethodCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, (String) paymentMethodCombo.getSelectedItem());
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(paymentMethodLabel);
        inputPanel.add(paymentMethodCombo);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Credit Card Panel
        JPanel creditCardPanel = new JPanel(new GridLayout(4, 2));
        creditCardPanel.add(new JLabel("Card Number:"));
        ccNumberField = new JTextField(10);
        creditCardPanel.add(ccNumberField);

        creditCardPanel.add(new JLabel("Card Holder:"));
        ccHolderField = new JTextField(10);
        creditCardPanel.add(ccHolderField);

        creditCardPanel.add(new JLabel("CVV:"));
        ccCVVField = new JTextField(3);
        creditCardPanel.add(ccCVVField);

        creditCardPanel.add(new JLabel("Expiry Date:"));
        ccExpiryField = new JTextField(5);
        creditCardPanel.add(ccExpiryField);

        // PayPal Panel
        JPanel payPalPanel = new JPanel(new GridLayout(2, 2));
        payPalPanel.add(new JLabel("Email:"));
        ppEmailField = new JTextField(10);
        payPalPanel.add(ppEmailField);

        payPalPanel.add(new JLabel("Password:"));
        ppPasswordField = new JPasswordField(10);
        payPalPanel.add(ppPasswordField);

        cardPanel.add(creditCardPanel, "Credit Card");
        cardPanel.add(payPalPanel, "PayPal");

        payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executePayment();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
        add(payButton, BorderLayout.SOUTH);

        cardLayout.show(cardPanel, "Credit Card");
    }

    private void executePayment() {
        double amount = Double.parseDouble(amountField.getText());
        String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

        PaymentContext context = new PaymentContext();
        if (paymentMethod.equals("Credit Card")) {
            String ccNumber = ccNumberField.getText();
            String ccHolder = ccHolderField.getText();
            String cvv = ccCVVField.getText();
            String expiry = ccExpiryField.getText();
            context.setPaymentStrategy(new CreditCardPayment(ccNumber, ccHolder, cvv, expiry));
        } else if (paymentMethod.equals("PayPal")) {
            String email = ppEmailField.getText();
            String password = ppPasswordField.getText();
            context.setPaymentStrategy(new PayPalPayment(email, password));
        }

        context.executePayment(amount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentSystemGUI().setVisible(true);
            }
        });
    }
}
