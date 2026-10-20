//overall objective of this code: Collect, Check, and Display student information...

import java.util.Scanner;

public class StudentValidation {

    
    // the ValidateStudent method 
    public static void validateStudent(String studentName, String studentNumber) {

        if (studentName.isEmpty() || studentNumber.isEmpty()) {
            System.out.println("Student information is incomplete.");
        } else {
            displayStudent(studentName, studentNumber);
        }
    }

   
    //  the display method
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
