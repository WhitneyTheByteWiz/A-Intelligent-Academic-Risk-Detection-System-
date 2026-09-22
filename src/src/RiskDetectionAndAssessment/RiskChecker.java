import java.util.Scanner;

public class RiskChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter average mark: ");
        double averageMark = scanner.nextDouble();

        System.out.print("Enter attendance percentage: ");
        double attendance = scanner.nextDouble();

        displayTitle();
        checkRisk(studentName, averageMark, attendance);

        scanner.close();
    }

    public static void displayTitle() {
        System.out.println("\nACADEMIC RISK DETECTION SYSTEM");
    }

    public static void checkRisk(String studentName, double averageMark, double attendance) {

        if (attendance < 60 || averageMark < 50) {
            System.out.println(studentName + " is at high risk of failing");
        } else if (attendance < 75) {
            System.out.println(studentName + " has moderate attendance");
        } else {
            System.out.println(studentName + " has good attendance");
        }
    }
}