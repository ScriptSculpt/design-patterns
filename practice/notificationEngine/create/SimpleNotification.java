package practice.notificationEngine.create;

public class SimpleNotification implements Notification {
    private String content;

    public SimpleNotification(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
