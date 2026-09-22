import java.util.Scanner;

public class StudentValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();

        if (studentName.isEmpty() || studentNumber.isEmpty()) {
            System.out.println("Student information is incomplete.");
        } else {
            System.out.println("Student information recorded successfully.");
            System.out.println("Name: " + studentName);
            System.out.println("Student Number: " + studentNumber);
        }

        scanner.close();
    }
}