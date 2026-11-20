package Notification;

/** Simulated email alert (prints to the console; no real email is sent). */
public class EmailNotification implements Notifiable {

    private String recipient;

    public EmailNotification(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient is required.");
        }
        this.recipient = recipient.trim();
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("[EMAIL to " + recipient + "] " + message);
    }
}
