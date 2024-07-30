//A test class to demonstrate Builder Pattern
package com.example.Builder;
public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer computer1 = new Computer.ComputerBuilder("500 GB", "8 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer computer2 = new Computer.ComputerBuilder("1 TB", "16 GB")
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}

