// src/com/example/subject/StockMarket.java
package com.example.subject;

import com.example.observer.Observer;
import java.util.ArrayList;
import java.util.List;
public class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;
    public StockMarket() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
