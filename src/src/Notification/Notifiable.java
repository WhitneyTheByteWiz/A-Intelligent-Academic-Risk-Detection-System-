package Notification;

/**
 * Week 9: interface. Any way of alerting someone about an academic risk
 * (email, SMS, ...) must provide notifyUser, and it must be public.
 */
public interface Notifiable {
    void notifyUser(String message);
}
