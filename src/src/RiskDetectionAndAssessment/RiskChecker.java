import java.util.Scanner;

public class RiskChecker {

    // Fields
    String studentName;
    double averageMark;
    double attendance;

    // Constructor
    public RiskChecker(
        String studentName,
        double averageMark,
        double attendance
    ) {
        this.studentName = studentName;
        this.averageMark = averageMark;
        this.attendance = attendance;
    }

    // Display system title
    public void displayTitle() {
        System.out.println(
            "\nACADEMIC RISK DETECTION SYSTEM"
        );
    }

    // Check student risk
    public void checkRisk() {

        if (attendance < 60 || averageMark < 50) {

            System.out.println(
                studentName +
                " is at high risk of failing"
            );

        } else if (attendance < 75) {

            System.out.println(
                studentName +
                " has moderate attendance"
            );

        } else {

            System.out.println(
                studentName +
                " has good attendance"
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(
            "Enter student name: "
        );

        String studentName =
            scanner.nextLine();

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

        // Create RiskChecker object
        RiskChecker riskChecker =
            new RiskChecker(
                studentName,
                averageMark,
                attendance
            );

        // Call object methods
        riskChecker.displayTitle();
        riskChecker.checkRisk();

        scanner.close();
    }
}
