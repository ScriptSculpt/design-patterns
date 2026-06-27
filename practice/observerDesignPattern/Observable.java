package practice.observerDesignPattern;

public interface Observable {
    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
    void notifySubscribers();
}
