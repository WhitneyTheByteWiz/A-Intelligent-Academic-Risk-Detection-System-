import java.util.Scanner;

public class SystemMenu {

    public void displayMenu() {

        String[] menuOptions = {
            "Student Records",
            "Academic Performance",
            "Attendance",
            "Risk Assessment",
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

    public int getUserChoice(Scanner scanner) {

        System.out.print("\nSelect an option: ");

        while (!scanner.hasNextInt()) {

            System.out.println(
                "Invalid input. Please enter a number from 1 to 5."
            );

            scanner.nextLine();

            System.out.print("Select an option: ");
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public void processChoice(int choice) {

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
                System.out.println(
                    "Invalid option. Please select from 1 to 5."
                );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SystemMenu menu = new SystemMenu();

        menu.displayMenu();

        int choice = menu.getUserChoice(scanner);

        menu.processChoice(choice);

        scanner.close();
    }
}
