import java.util.Scanner;

public class AcademicPerformance{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student mark: ");
        double mark = scanner.nextDouble();

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark.");
        } else if (mark < 50) {
            System.out.println("Low academic performance.");
        } else if (mark < 70) {
            System.out.println("Moderate academic performance.");
        } else {
            System.out.println("Good academic performance.");
        }

        scanner.close();
    }
}
