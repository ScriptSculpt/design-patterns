package practice.observerDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Observable {

    List<Observer> observers = new ArrayList<>();
    List<String> videos = new ArrayList<>();
    String latestVideo;


    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        System.out.println("Removing subscriber: " + ((Subscriber) observer).name + " from channel...");
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(Observer observer: observers) {
            observer.update();
        }
    }

    public String getLatestVideo() {
        return latestVideo;
    }

    public void setLatestVideo(String latestVideo) {
        videos.add(latestVideo);
        this.latestVideo = latestVideo;
        notifySubscribers();
    }
    
}
