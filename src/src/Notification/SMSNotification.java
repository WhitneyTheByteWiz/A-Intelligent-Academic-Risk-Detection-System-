package Notification;

/** Simulated SMS alert (prints to the console; no real SMS is sent). */
public class SMSNotification implements Notifiable {

    private String recipient;

    public SMSNotification(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient is required.");
        }
        this.recipient = recipient.trim();
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("[SMS to " + recipient + "] " + message);
    }
}
