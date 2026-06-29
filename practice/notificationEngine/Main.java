package practice.notificationEngine;



import practice.notificationEngine.create.Notification;
import practice.notificationEngine.create.SignatureDecorator;
import practice.notificationEngine.create.SimpleNotification;
import practice.notificationEngine.create.TimestampDecorator;
import practice.notificationEngine.observe.Logger;
import practice.notificationEngine.observe.NotificationEngine;
import practice.notificationEngine.observe.NotificationObservable;
import practice.notificationEngine.observe.Observer;
import practice.notificationEngine.send.Email;
import practice.notificationEngine.service.NotificationService;

public class Main {
    public static void main(String[] args) {

        System.out.println(" =================================== ");
        NotificationService notificationService = NotificationService.getInstance();

        NotificationObservable observable = notificationService.getObservable();
        
        Observer logger = new Logger(observable);

        Observer notificationEngine = new NotificationEngine(observable, new Email());

        System.out.println(" =================================== ");
        
        observable.addObserver(logger);
        observable.addObserver(notificationEngine);

        System.out.println(" =================================== ");

        Notification notification = new SimpleNotification("Hello world");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification);

        notificationService.sendNotification(notification);
    }
}
