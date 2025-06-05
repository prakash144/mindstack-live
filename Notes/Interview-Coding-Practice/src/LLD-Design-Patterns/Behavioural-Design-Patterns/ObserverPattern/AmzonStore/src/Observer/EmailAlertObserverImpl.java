package Observer;

import Obervable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StocksObservable observable;

    // Constructor injection
    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up!");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("Sending email to " + emailId);
    }
}
