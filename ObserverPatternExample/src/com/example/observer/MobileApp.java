// src/com/example/observer/MobileApp.java
package com.example.observer;

public class MobileApp implements Observer {
    private double stockPrice;

    @Override
    public void update(double stockPrice) {
        this.stockPrice = stockPrice;
        display();
    }

    public void display() {
        System.out.println("MobileApp: Stock price updated to " + stockPrice);
    }
}



