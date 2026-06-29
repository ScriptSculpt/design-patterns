package practice.notificationEngine.observe;

import practice.notificationEngine.send.NotificationStrategy;

public class NotificationEngine implements Observer {
    private NotificationObservable observable;
    private NotificationStrategy notificationStrategy;

    public NotificationEngine(NotificationObservable observable, NotificationStrategy notificationStrategy) {
        this.observable = observable;
        this.notificationStrategy = notificationStrategy;
    }

    @Override
    public void update() {
        System.out.println("NotificationEngine updated with latest video: " + observable.getLatestNotification());
        notificationStrategy.sendNotification(observable.getLatestNotification());
        System.out.println(" ================================== ");
    }
    
}
