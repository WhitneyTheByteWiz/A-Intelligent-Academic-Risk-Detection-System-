package RiskDetectionAndAssessment;

import java.util.Scanner;

public class RiskAssessment {

    // Fields
    double averageMark;
    double attendance;

    // Constructor
    public RiskAssessment(
        double averageMark,
        double attendance
    ) {
        this.averageMark = averageMark;
        this.attendance = attendance;
    }

    // Check student risk level
    public void checkRisk() {

        if (attendance < 60 ||
            averageMark < 50) {

            System.out.println(
                "Risk Level: HIGH RISK"
            );

        } else if (attendance < 75) {

            System.out.println(
                "Risk Level: MODERATE RISK"
            );

        } else {

            System.out.println(
                "Risk Level: LOW RISK"
            );
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(
            "Enter average mark: "
        );

        double averageMark =
            scanner.nextDouble();

        System.out.print(
            "Enter attendance percentage: "
        );

        double attendance =
            scanner.nextDouble();

        // Create RiskAssessment object
        RiskAssessment assessment =
            new RiskAssessment(
                averageMark,
                attendance
            );

        // Check risk level
        assessment.checkRisk();

        scanner.close();
    }
}
