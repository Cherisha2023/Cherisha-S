// src/com/example/gui/StockMarketGUI.java
package com.example.gui;

import com.example.subject.StockMarket;
import com.example.observer.MobileApp;
import com.example.observer.WebApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockMarketGUI extends JFrame {
    private StockMarket stockMarket;
    private JTextField stockPriceField;
    private JTextArea logArea;

    public StockMarketGUI(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
        setTitle("Stock Market Monitor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Stock Price:"));
        stockPriceField = new JTextField(10);
        inputPanel.add(stockPriceField);
        JButton updateButton = new JButton("Update Price");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStockPrice();
            }
        });
        inputPanel.add(updateButton);
        panel.add(inputPanel);

        logArea = new JTextArea();
        logArea.setEditable(false);
        panel.add(new JScrollPane(logArea));

        add(panel);

        // Register observers
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
    }

    private void updateStockPrice() {
        try {
            double price = Double.parseDouble(stockPriceField.getText());
            stockMarket.setStockPrice(price);
            logArea.append("Stock price updated to " + price + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
