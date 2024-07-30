package com.example.adapter;

import com.example.adaptee.PayPal;
import com.example.target.PaymentProcessor;

public class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(String amount) {
        payPal.makePayment(amount);
    }
}

