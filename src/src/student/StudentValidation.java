import java.util.Scanner;

public class StudentValidation {

    // METHOD 1
    public static void validateStudent(String studentName, String studentNumber) {

        if (studentName.isEmpty() || studentNumber.isEmpty()) {
            System.out.println("Student information is incomplete.");
        } else {
            displayStudent(studentName, studentNumber);
        }
    }

    // METHOD 2
    public static void displayStudent(String studentName, String studentNumber) {

        System.out.println("Student information recorded successfully.");
        System.out.println("Name: " + studentName);
        System.out.println("Student Number: " + studentNumber);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();

        validateStudent(studentName, studentNumber);

        scanner.close();
    }
}
