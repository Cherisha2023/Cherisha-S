// src/com/example/observer/WebApp.java
package com.example.observer;

public class WebApp implements Observer {
    private double stockPrice;

    @Override
    public void update(double stockPrice) {
        this.stockPrice = stockPrice;
        display();
    }

    public void display() {
        System.out.println("WebApp: Stock price updated to " + stockPrice);
    }
}