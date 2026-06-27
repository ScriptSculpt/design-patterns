package practice.observerDesignPattern;

public class Subscriber implements Observer {
    String name;
    Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println(name + " updated with latest video: " + channel.getLatestVideo());
    }
}
