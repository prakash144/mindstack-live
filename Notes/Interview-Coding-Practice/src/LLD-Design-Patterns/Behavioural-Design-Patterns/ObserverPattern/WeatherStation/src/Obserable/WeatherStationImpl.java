package Obserable;

import Observer.DisplayObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationImpl implements WeatherStationObservable{
    public List<DisplayObserver> observerList = new ArrayList<>();
    public float temperature;

    @Override
    public void add(DisplayObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(DisplayObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(DisplayObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }


    @Override
    public float getTemperature() {
        return temperature;
    }
}
