package src.RiskChecker;

import java.util.Scanner;

public class RiskChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String studentName = "John";
        double averageMark = 55;
        double attendance = 68;

        if (attendance < 60 || averageMark < 50) {

            System.out.println(studentName + " is at high risk of failing");

        } else if (attendance < 75) {

            System.out.println(studentName + " has moderate attendance");

        } else {

            System.out.println(studentName + " has good attendance");
        }
    }
}