package Notification;

import RiskDetectionAndAssessment.RiskAssessment;
import student.Student;

/**
 * Builds the alert text for a student and sends it through every channel.
 * The loop works on Notifiable[], so new channels need no changes here.
 */
public class RiskAlertService {

    public static String buildMessage(Student student) {

        RiskAssessment assessment = new RiskAssessment(
            student.getAverageMark(),
            student.getAttendance()
        );

        return String.format(
            "%s - %s. Average mark %.2f, attendance %.1f%%.",
            student.describe(),
            assessment.getRiskLevelName(),
            student.getAverageMark(),
            student.getAttendance()
        );
    }

    public static void sendAlert(Student student, Notifiable[] channels) {

        String message = buildMessage(student);

        for (int i = 0; i < channels.length; i++) {
            channels[i].notifyUser(message);
        }
    }
}
