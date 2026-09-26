import java.util.Scanner;

public class main {

    static final int MAX_STUDENTS = 10;

    static String[] studentNames = new String[MAX_STUDENTS];
    static String[] studentNumbers = new String[MAX_STUDENTS];
    static double[] averageMarks = new double[MAX_STUDENTS];
    static double[] attendanceRecords = new double[MAX_STUDENTS];

    static int studentCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            displayMenu();

            System.out.print("\nEnter your choice: ");
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
                    System.out.println("\nInvalid option.");
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


    // Add a student
    public static void addStudent(Scanner scanner) {

        if (studentCount >= MAX_STUDENTS) {

            System.out.println("\nMaximum number of students reached.");
            return;
        }

        System.out.println();
        System.out.println("========== ADD STUDENT ==========");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();

        if (name.isEmpty() || studentNumber.isEmpty()) {

            System.out.println("Student name and number cannot be empty.");
            return;
        }

        double average = enterMarks(scanner);

        System.out.print("\nEnter attendance percentage: ");
        double attendance = scanner.nextDouble();
        scanner.nextLine();

        while (attendance < 0 || attendance > 100) {

            System.out.println("Attendance must be between 0 and 100.");

            System.out.print("Enter attendance percentage: ");
            attendance = scanner.nextDouble();
            scanner.nextLine();
        }

        studentNames[studentCount] = name;
        studentNumbers[studentCount] = studentNumber;
        averageMarks[studentCount] = average;
        attendanceRecords[studentCount] = attendance;

        studentCount++;

        System.out.println();
        System.out.println("Student added successfully.");
    }


    // Enter marks and calculate average
    public static double enterMarks(Scanner scanner) {

        System.out.print("\nHow many marks do you want to enter? ");
        int numberOfMarks = scanner.nextInt();

        while (numberOfMarks <= 0) {

            System.out.println("Number of marks must be greater than 0.");

            System.out.print("How many marks do you want to enter? ");
            numberOfMarks = scanner.nextInt();
        }

        double[] marks = new double[numberOfMarks];

        for (int i = 0; i < marks.length; i++) {

            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();

            while (marks[i] < 0 || marks[i] > 100) {

                System.out.println("Mark must be between 0 and 100.");

                System.out.print("Enter mark " + (i + 1) + ": ");
                marks[i] = scanner.nextDouble();
            }
        }

        double average = calculateAverage(marks);

        System.out.println("Average Mark: " + average);

        return average;
    }


    // Calculate average mark
    public static double calculateAverage(double[] marks) {

        double total = 0;

        for (int i = 0; i < marks.length; i++) {

            total = total + marks[i];
        }

        return total / marks.length;
    }


    // View all students
    public static void viewStudents() {

        if (studentCount == 0) {

            System.out.println("\nNo students have been added.");
            return;
        }

        System.out.println();
        System.out.println("========== STUDENTS ==========");

        for (int i = 0; i < studentCount; i++) {

            System.out.println();
            System.out.println("Student " + (i + 1));
            System.out.println("Name: " + studentNames[i]);
            System.out.println("Student Number: " + studentNumbers[i]);
            System.out.println("Average Mark: " + averageMarks[i]);
            System.out.println("Attendance: " + attendanceRecords[i] + "%");
            System.out.println("------------------------------");
        }
    }


    // Check risk for one student
    public static void checkStudentRisk(Scanner scanner) {

        if (studentCount == 0) {

            System.out.println("\nNo students available.");
            return;
        }

        System.out.print("\nEnter student number: ");
        String targetStudentNumber = scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {

            if (studentNumbers[i].equals(targetStudentNumber)) {

                checkRisk(
                    studentNames[i],
                    averageMarks[i],
                    attendanceRecords[i]
                );

                return;
            }
        }

        System.out.println("Student not found.");
    }


    // Determine student risk
    public static void checkRisk(
        String name,
        double averageMark,
        double attendance
    ) {

        System.out.println();
        System.out.println("========== RISK ASSESSMENT ==========");
        System.out.println("Student: " + name);
        System.out.println("Average Mark: " + averageMark);
        System.out.println("Attendance: " + attendance + "%");

        if (attendance < 60 || averageMark < 50) {

            System.out.println("Risk Level: HIGH RISK");

        } else if (attendance < 75) {

            System.out.println("Risk Level: MODERATE RISK");

        } else {

            System.out.println("Risk Level: LOW RISK");
        }

        System.out.println("=====================================");
    }


    // Display full report for one student
    public static void displayFullReport(Scanner scanner) {

        if (studentCount == 0) {

            System.out.println("\nNo student records available.");
            return;
        }

        System.out.print("\nEnter student number: ");
        String targetStudentNumber = scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {

            if (studentNumbers[i].equals(targetStudentNumber)) {

                System.out.println();
                System.out.println("========== FULL REPORT ==========");
                System.out.println("Name: " + studentNames[i]);
                System.out.println("Student Number: " + studentNumbers[i]);
                System.out.println("Average Mark: " + averageMarks[i]);
                System.out.println(
                    "Attendance: " + attendanceRecords[i] + "%"
                );

                if (attendanceRecords[i] < 60 ||
                    averageMarks[i] < 50) {

                    System.out.println("Risk Level: HIGH RISK");

                } else if (attendanceRecords[i] < 75) {

                    System.out.println("Risk Level: MODERATE RISK");

                } else {

                    System.out.println("Risk Level: LOW RISK");
                }

                System.out.println("=================================");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}