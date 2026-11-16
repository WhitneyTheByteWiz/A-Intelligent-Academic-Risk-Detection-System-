package Academic;

import java.util.Scanner;

public class PerformanceChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student mark: ");
        double mark = scanner.nextDouble();

        // Reuse the performance rules in AcademicPerformance.
        AcademicPerformance.checkPerformance(mark);

        scanner.close();
    }
}
