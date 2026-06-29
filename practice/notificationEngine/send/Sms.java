package practice.notificationEngine.send;

public class Sms implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
    
}
