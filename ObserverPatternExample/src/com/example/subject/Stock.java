// src/com/example/subject/Stock.java
package com.example.subject;

import com.example.observer.Observer;

public interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
