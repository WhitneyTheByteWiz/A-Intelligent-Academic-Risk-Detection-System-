import java.util.Scanner;

public class AcademicPerformance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] marks = new double[5];

        for (int i = 0; i < marks.length; i++) {

            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
        }

        System.out.println("\nACADEMIC PERFORMANCE");

        for (int i = 0; i < marks.length; i++) {

            System.out.println("Mark: " + marks[i]);
            checkPerformance(marks[i]);
        }

        double average = calculateAverage(marks);

        System.out.println("\nAverage Mark: " + average);

        scanner.close();
    }

    public static void checkPerformance(double mark) {

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark.");
        } else if (mark < 50) {
            System.out.println("Low academic performance.");
        } else if (mark < 70) {
            System.out.println("Moderate academic performance.");
        } else {
            System.out.println("Good academic performance.");
        }
    }

    public static double calculateAverage(double[] marks) {

        double total = 0;

        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }

        return total / marks.length;
    }
}
