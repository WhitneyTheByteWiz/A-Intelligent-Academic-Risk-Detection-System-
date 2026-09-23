import java.util.Scanner;

public class SystemMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        displayMenu();

        System.out.print("Select an option: ");
        int choice = scanner.nextInt();

        processChoice(choice);

        scanner.close();
    }

    public static void displayMenu() {
String[] menuOptions={
        "1. Student Records",
        "2. Academic Performance",
        "3. Attendance",
        "4. Risk Assessment",
        "5. Exit"
    }; 

    System.out.println("ACADEMIC RISK DETECTION SYSTEM")
 for (int i=0;i<menuOptions.length;i++){
        System.out.println(i+1)+"." + menuOptions[i]
            );
    }
    }
    public static void processChoice(int choice) {

        switch (choice) {
            case 1:
                System.out.println("Student Records selected.");
                break;

            case 2:
                System.out.println("Academic Performance selected.");
                break;

            case 3:
                System.out.println("Attendance selected.");
                break;

            case 4:
                System.out.println("Risk Assessment selected.");
                break;

            case 5:
                System.out.println("Exiting system.");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}
