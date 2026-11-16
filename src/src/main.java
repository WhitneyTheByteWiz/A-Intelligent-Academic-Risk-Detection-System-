import java.util.Scanner;

import Academic.AcademicPerformance;
import Attendance.AttendanceChecker;
import RiskDetectionAndAssessment.RiskAssessment;
import student.Student;
import student.StudentValidation;

public class main {

    static final int MAX_STUDENTS = 10;

    // Each array position now stores one complete Student object.
    static Student[] students = new Student[MAX_STUDENTS];
    static int studentCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            displayMenu();

            System.out.print("\nEnter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println(
                    "Invalid input. Please enter a number from 1 to 5."
                );

                scanner.nextLine();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent(scanner);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    checkStudentRisk(scanner);
                    break;

                case 4:
                    displayFullReport(scanner);
                    break;

                case 5:
                    System.out.println("\nExiting system...");
                    break;

                default:
                    System.out.println(
                        "\nInvalid option. Please select from 1 to 5."
                    );
            }

        } while (choice != 5);

        scanner.close();
    }

    // Display main menu
    public static void displayMenu() {

        String[] menuOptions = {
            "Add Student",
            "View All Students",
            "Check Student Risk",
            "View Student Full Report",
            "Exit"
        };

        System.out.println();
        System.out.println("================================");
        System.out.println(" ACADEMIC RISK DETECTION SYSTEM");
        System.out.println("================================");

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
    }

    // Add a new student
    public static void addStudent(Scanner scanner) {

        if (studentCount >= MAX_STUDENTS) {
            System.out.println(
                "\nMaximum number of students reached."
            );
            return;
        }

        System.out.println();
        System.out.println("========== ADD STUDENT ==========");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine().trim();

        if (name.isEmpty() || studentNumber.isEmpty()) {
            System.out.println(
                "Student name and number cannot be empty."
            );
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentNumber().equalsIgnoreCase(studentNumber)) {
                System.out.println(
                    "A student with that student number already exists."
                );
                return;
            }
        }

        StudentValidation.validateStudent(name, studentNumber);

        double average = enterMarks(scanner);

        System.out.print("\nEnter attendance percentage: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            System.out.print("Enter attendance percentage: ");
        }

        double attendance = scanner.nextDouble();
        scanner.nextLine();

        while (attendance < 0 || attendance > 100) {

            System.out.println(
                "Attendance must be between 0 and 100."
            );

            System.out.print("Enter attendance percentage: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.print("Enter attendance percentage: ");
            }

            attendance = scanner.nextDouble();
            scanner.nextLine();
        }

        students[studentCount] = new Student(
            name,
            studentNumber,
            average,
            attendance
        );

        studentCount++;

        System.out.println();
        System.out.println("Attendance assessment:");
        AttendanceChecker attendanceChecker =
            new AttendanceChecker(attendance);
        attendanceChecker.checkAttendance();

        System.out.println("\nStudent added successfully.");
    }

    // Enter student marks
    public static double enterMarks(Scanner scanner) {

        System.out.print("\nHow many marks do you want to enter? ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.nextLine();
            System.out.print("How many marks do you want to enter? ");
        }

        int numberOfMarks = scanner.nextInt();

        while (numberOfMarks <= 0) {
            System.out.println("Number of marks must be greater than 0.");
            System.out.print("How many marks do you want to enter? ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
                System.out.print("How many marks do you want to enter? ");
            }

            numberOfMarks = scanner.nextInt();
        }

        double[] marks = new double[numberOfMarks];

        for (int i = 0; i < marks.length; i++) {

            System.out.print("Enter mark " + (i + 1) + ": ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                System.out.print("Enter mark " + (i + 1) + ": ");
            }

            marks[i] = scanner.nextDouble();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Mark must be between 0 and 100.");
                System.out.print("Enter mark " + (i + 1) + ": ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    System.out.print("Enter mark " + (i + 1) + ": ");
                }

                marks[i] = scanner.nextDouble();
            }
        }

        scanner.nextLine();

        System.out.println("\nINDIVIDUAL MARK PERFORMANCE");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
            AcademicPerformance.checkPerformance(marks[i]);
        }

        double average = calculateAverage(marks);
        System.out.printf("\nAverage Mark: %.2f%n", average);

        return average;
    }

    // Calculate average mark
    public static double calculateAverage(double[] marks) {
        return AcademicPerformance.calculateAverage(marks);
    }

    // View all students
    public static void viewStudents() {

        if (studentCount == 0) {
            System.out.println("\nNo students have been added.");
            return;
        }

        System.out.println("\n========== STUDENTS ==========");

        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];

            System.out.println("\nStudent " + (i + 1));
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Student Number: " + student.getStudentNumber());
            student.getAcademicRecord().displayAcademicRecord();
            System.out.println("Attendance: " + student.getAttendance() + "%");
            System.out.println("------------------------------");
        }
    }

    // Display students for selection
    public static void displayStudentList() {

        System.out.println("\n========== SELECT STUDENT ==========");

        for (int i = 0; i < studentCount; i++) {
            System.out.println(
                (i + 1) + ". " + students[i].getStudentName()
                + " - " + students[i].getStudentNumber()
            );
        }

        System.out.println("====================================");
    }

    // Get selected student array index
    public static int selectStudent(Scanner scanner) {

        displayStudentList();
        System.out.print("\nSelect student: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            System.out.print("Select student: ");
        }

        int selection = scanner.nextInt();
        scanner.nextLine();

        if (selection < 1 || selection > studentCount) {
            System.out.println("\nInvalid student selection.");
            return -1;
        }

        return selection - 1;
    }

    // Check risk for one selected student
    public static void checkStudentRisk(Scanner scanner) {

        if (studentCount == 0) {
            System.out.println("\nNo students available.");
            return;
        }

        int index = selectStudent(scanner);
        if (index == -1) {
            return;
        }

        Student student = students[index];
        checkRisk(
            student.getStudentName(),
            student.getAverageMark(),
            student.getAttendance()
        );
    }

    // Determine risk level
    public static void checkRisk(
        String name,
        double averageMark,
        double attendance
    ) {

        System.out.println("\n========== RISK ASSESSMENT ==========");
        System.out.println("Student: " + name);
        System.out.printf("Average Mark: %.2f%n", averageMark);
        System.out.println("Attendance: " + attendance + "%");

        RiskAssessment assessment =
            new RiskAssessment(averageMark, attendance);
        assessment.checkRisk();

        System.out.println("=====================================");
    }

    // Display full report for one selected student
    public static void displayFullReport(Scanner scanner) {

        if (studentCount == 0) {
            System.out.println("\nNo student records available.");
            return;
        }

        int index = selectStudent(scanner);
        if (index == -1) {
            return;
        }

        Student student = students[index];

        System.out.println("\n========== FULL REPORT ==========");
        System.out.println("Name: " + student.getStudentName());
        System.out.println("Student Number: " + student.getStudentNumber());
        System.out.printf("Average Mark: %.2f%n", student.getAverageMark());
        System.out.println("Attendance: " + student.getAttendance() + "%");

        RiskAssessment assessment = new RiskAssessment(
            student.getAverageMark(),
            student.getAttendance()
        );
        assessment.checkRisk();

        System.out.println("=================================");
    }
}
