package practice.notificationEngine.create;

public class TimestampDecorator extends NotificationDecorator {
    public TimestampDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "Timestamp: " + System.currentTimeMillis() + " - " + notification.getContent();
    }
}
