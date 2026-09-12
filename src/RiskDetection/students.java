import java.util.Scanner;

public class StudentRiskDetection{
  public static void main(String [] args)
  {
    Scanner input=new Scanner(System.in);
    System.out.println("================================");
     System.out.println("STUDENT RISK  DETECTION SYSTEM");
    System.out.println("================================");
      System.out.println("Welecome!Please enter your details.");
      System.out.println();
    
      System.out.println("Enter your name:");
    String name=input.nextLine();
      System.out.println("Enter your student ID");
    String studentID=input.nextLine();
      System.out.print("Enter your age:");
    int age=input.nextInt();
    input.nextLine();
    System.out.print("Enter your programme:");
    String programme=input.nextLine();
    
      System.out.println("Name:" + name);
       System.out.println("Student ID:" + studentID);
        System.out.println("Age:" + age);
        System.out.println("Programme:" + programme);

  input.close();
  }
}
