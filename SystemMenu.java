import java.util.Scanner;
public class SystemMenu{
public static void main(String[] args){
Scanner scanner=new Scanner(System.in);
System.out.println("ACADEMIC RISK DETECTION SYSTEM");
System.out.println("1.Student Records");
System.out.println("2.Academic Performance");
System.out.println("3.Attendance");
System.out.println("4.Risk Assesment");
System.out.println("5.Exit");
System.out.println("Select an option");
int choice= scanner.nextInt();
switch(choice){
case 1:
System.out.println("Student Records selected");
break;
case 2:
System.out.println("Academic Performance selected");
break;
case 3:
System.out.println("Attendance selected");
break;
case 4:
System.out.println("Risk assesment selected");
break;
case 5:
System.out.println("Exiting system");
break;
default:
System.out.println("Invalid option.");
}
scanner.close();
}
}
