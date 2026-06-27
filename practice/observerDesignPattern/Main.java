package practice.observerDesignPattern;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel();

        Observer subscriber1 = new Subscriber("Subscriber 1", channel);
        Observer subscriber2 = new Subscriber("Subscriber 2", channel);

        channel.addSubscriber(subscriber1);
        channel.addSubscriber(subscriber2);
        channel.setLatestVideo("Video 1");
        System.out.println(" ---------------------------------------------------- ");
        channel.setLatestVideo("Video 2");
        System.out.println(" ---------------------------------------------------- ");
        channel.setLatestVideo("Video 3");

        System.out.println(" ---------------------------------------------------- ");
        channel.removeSubscriber(subscriber2);

        channel.setLatestVideo("Video 4");

    }
}
