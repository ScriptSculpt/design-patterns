package practice.notificationEngine.create;

public class SignatureDecorator extends NotificationDecorator {
    public SignatureDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "@signature!!!" + "-" + notification.getContent();
    }
}
