package com.example.adapter;

import com.example.adaptee.Stripe;
import com.example.target.PaymentProcessor;

public class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(String amount) {
        stripe.pay(amount);
    }
}

