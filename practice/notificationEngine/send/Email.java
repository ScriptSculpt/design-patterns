package practice.notificationEngine.send;

public class Email implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
    
    
}
