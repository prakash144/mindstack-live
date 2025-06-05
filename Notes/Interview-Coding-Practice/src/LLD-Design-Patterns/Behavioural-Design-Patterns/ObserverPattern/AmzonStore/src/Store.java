/*
   FLOWCHART:

   +-----------------------+           +---------------------------+
   | StocksObservable      |           | NotificationAlertObserver |
   | (IphoneObservableImpl)|           |  (Email/Mobile Observers) |
   +-----------------------+           +---------------------------+
         | add(observer)                    | update()
         | notifyObservers()                |
         V                                  V
   +--------------------------+          +------------------------+
   | Stock Change (Set Count) |--------->| Alert via Email/Mobile |
   +--------------------------+          +------------------------+
*/

/*
 * Main class for demonstrating the Observer Design Pattern.
 * Observable: IphoneObservableImpl.
 * Observers: EmailAlertObserverImpl, MobileAlertObserverImpl.
 * When stock count is updated, observers are notified.
 */

import Obervable.IphoneObservableImpl;
import Obervable.StocksObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MobileAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        // Create the Observable for iPhone stock
        StocksObservable iphoneStockObservable = new IphoneObservableImpl();

        // Create Observers (subscribers) for email and mobile alerts
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("abc1_username", iphoneStockObservable);

        // Register observers to the observable
        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        // Update stock count, observers will be notified
        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(10);
    }
}
