package Observer;

import Obserable.WeatherStationObservable;

public class TVDisplayObserver implements DisplayObserver{
    WeatherStationObservable observable;

    public TVDisplayObserver(WeatherStationObservable weatherStationObservable) {
        this.observable = weatherStationObservable;
    }

    @Override
    public void update() {
        System.out.println("TVDisplayObserver update: " + observable.getTemperature());
    }
}
