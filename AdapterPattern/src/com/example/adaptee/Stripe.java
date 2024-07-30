package com.example.adaptee;

public class Stripe {
    public void pay(String amount) {
        System.out.println("Processing payment of " + amount + " through Stripe.");
    }
}

