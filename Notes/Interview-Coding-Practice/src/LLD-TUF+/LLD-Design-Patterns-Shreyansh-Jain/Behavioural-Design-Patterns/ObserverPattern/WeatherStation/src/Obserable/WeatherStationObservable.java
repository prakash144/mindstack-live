package Obserable;

import Observer.DisplayObserver;

public interface WeatherStationObservable {
    void add(DisplayObserver observer);
    void remove(DisplayObserver observer);
    void notifyObservers();
    void setTemperature(float temperature);
    float getTemperature();
}
