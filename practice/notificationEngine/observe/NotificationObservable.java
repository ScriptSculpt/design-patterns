package practice.notificationEngine.observe;

import java.util.ArrayList;
import java.util.List;

import practice.notificationEngine.create.Notification;

public class NotificationObservable implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();
    private Notification latestNotification;

    @Override
    public void addObserver(Observer observer) {
        System.out.println("Adding observer...");
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers() {

        for(Observer observer: observers) {
            System.out.println("Notifying observer one by one...");
            observer.update();
        } 
    }

    public void addNotification(Notification notification) {
        notifications.add(notification.getContent());
        this.latestNotification = notification;
        notifyObservers();
    }

    public String getLatestNotification() {
        return latestNotification.getContent();
    }
    
}
