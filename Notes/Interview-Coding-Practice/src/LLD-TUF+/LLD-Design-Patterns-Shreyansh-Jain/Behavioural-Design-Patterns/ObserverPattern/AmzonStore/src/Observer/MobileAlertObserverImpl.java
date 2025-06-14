package Observer;

import Obervable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userName;
    StocksObservable observable;

    // Constructor injection
    public MobileAlertObserverImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "product is in stock hurry up!");
    }

    private void sendMsgOnMobile(String userName, String msg){
        System.out.println("msg sent to: " + userName);
    }
}
