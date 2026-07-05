package practice.proxyDesignPattern;

public class User {
    private String name;
    private Boolean isPremium;

    public User(String name, Boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public String getName() {
        return name;
    }

    public Boolean isPremium() {
        return isPremium;
    }
}
