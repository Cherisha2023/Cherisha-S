// src/com/example/Main.java
package com.example;

import com.example.subject.StockMarket;
import com.example.gui.StockMarketGUI;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        StockMarketGUI gui = new StockMarketGUI(stockMarket);
        gui.setVisible(true);
    }
}
