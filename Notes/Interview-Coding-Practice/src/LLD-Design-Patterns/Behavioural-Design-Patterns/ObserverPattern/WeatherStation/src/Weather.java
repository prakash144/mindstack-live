import Obserable.WeatherStationImpl;
import Obserable.WeatherStationObservable;
import Observer.DisplayObserver;
import Observer.MobileDisplayObserver;
import Observer.TVDisplayObserver;

// =======================================
// Weather Monitoring System Using Observer Pattern
// =======================================

/*
Flowchart Explanation (Observer Pattern for Weather Monitoring):

1. WeatherStationObservable (Subject)
   └── add(observer) -> Adds DisplayObserver (TV or Mobile) to a list of subscribers.
   └── remove(observer) -> Removes a DisplayObserver from the list of subscribers.
   └── notifyObservers() -> Notifies all subscribers when there is a change (e.g., temperature change).
   └── setTemperature() -> Sets the new temperature and triggers the notifyObservers() method.

2. TVDisplayObserver / MobileDisplayObserver (Observers)
   └── update() -> Receives the updated temperature when notifyObservers() is called.

Main Class:
Weather (Client)
   └── Initializes WeatherStationObservable (subject).
   └── Creates two Observers: TVDisplayObserver and MobileDisplayObserver.
   └── Observers are registered to the subject (weatherStation.add()).
   └── A new temperature is set via setTemperature(), which triggers the notifyObservers() to alert all registered observers.


            +-------------------------+
            | Weather (Main)          |
            +-------------------------+
                       |
                       v
            +-------------------------+
            | WeatherStationImpl      |
            | - Implements Observable |
            +-------------------------+
                       |
                       v
            +-------------------------+     +----------------------------+
            | TVDisplayObserver        |    | MobileDisplayObserver      |
            | - Implements Observer    |    | - Implements Observer      |
            +-------------------------+     +----------------------------+
                       |                                 |
                       +---------------------------------+
                                       |
                               +-------------------+
                               | setTemperature(42)|
                               +-------------------+
                                       |
                               +-------------------+
                               | notifyObservers() |
                               +-------------------+
                                       |
                       +-----------------------------+
                       | TVDisplayObserver.update()  |
                       +-----------------------------+
                                       |
                       +--------------------------------+
                       | MobileDisplayObserver.update() |
                       +--------------------------------+

*/

// =======================================
// Main Class to Simulate the Weather System
// =======================================


public class Weather {
    public static void main(String[] args) {
        WeatherStationObservable weatherStation = new WeatherStationImpl();

        DisplayObserver observer1 = new TVDisplayObserver(weatherStation);
        DisplayObserver observer2 = new TVDisplayObserver(weatherStation);
        DisplayObserver observer3 = new MobileDisplayObserver(weatherStation);

        weatherStation.add(observer1);
        weatherStation.add(observer2);
        weatherStation.add(observer3);

        weatherStation.setTemperature(42);
    }
}