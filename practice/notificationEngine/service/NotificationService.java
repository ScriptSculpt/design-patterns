package practice.notificationEngine.service;

import java.util.ArrayList;
import java.util.List;

import practice.notificationEngine.create.Notification;
import practice.notificationEngine.observe.NotificationObservable;

public class NotificationService {
    private static NotificationService INSTANCE = null;
    private List<Notification> notifications = new ArrayList<>();
    private NotificationObservable observable;


    private NotificationService() {
        System.out.println("NotificationService class constructor called");
        observable = new NotificationObservable();
    }


    public static synchronized NotificationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationService();
        }
        return INSTANCE;
    }

    public NotificationObservable getObservable() { 
        return observable; 
    }

    public void sendNotification(Notification notification) {
        System.out.println("Sending notification: " + notification.getContent());
        notifications.add(notification);
        observable.addNotification(notification);
    }
}
