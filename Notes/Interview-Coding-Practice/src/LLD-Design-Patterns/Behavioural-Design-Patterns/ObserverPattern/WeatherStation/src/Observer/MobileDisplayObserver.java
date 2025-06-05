package Observer;

import Obserable.WeatherStationObservable;

public class MobileDisplayObserver implements DisplayObserver {
    public WeatherStationObservable observable;

    public MobileDisplayObserver(WeatherStationObservable weatherStationObservable) {
        this.observable = weatherStationObservable;
    }

    @Override
    public void update() {
        System.out.println("MobileDisplayObserver update: " + observable.getTemperature());
    }
}
