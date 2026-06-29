package practice.notificationEngine.observe;

public class Logger implements Observer {

    private NotificationObservable observable;

    public Logger(NotificationObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Logger updated with latest video: " + observable.getLatestNotification());
        System.out.println(" ================================== ");
    }
    
}
