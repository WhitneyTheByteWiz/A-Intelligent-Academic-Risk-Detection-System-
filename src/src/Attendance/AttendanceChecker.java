import java.util.Scanner;

public class AttendanceChecker {

     public static void checkAttendance(double attendance) {

        if (attendance < 0 || attendance > 100) {
            System.out.println("Invalid attendance percentage.");
        } else if (attendance < 60) {
            System.out.println("Low attendance.");
        } else if (attendance < 75) {
            System.out.println("Moderate attendance.");
        } else {
            System.out.println("Good attendance.");
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter attendance percentage: ");
        double attendance = scanner.nextDouble();

        checkAttendance(attendance);

        scanner.close();
    }
}