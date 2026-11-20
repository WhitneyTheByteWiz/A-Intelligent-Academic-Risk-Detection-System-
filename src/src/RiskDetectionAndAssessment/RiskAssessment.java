package RiskDetectionAndAssessment;

import java.util.Scanner;

public class RiskAssessment {

    // Fields
    double averageMark;
    double attendance;

    // Week 9: one array holds different rule objects (polymorphism).
    private RiskRule[] rules = {
        new AcademicRiskRule(),
        new AttendanceRiskRule()
    };

    // Constructor
    public RiskAssessment(
        double averageMark,
        double attendance
    ) {
        this.averageMark = averageMark;
        this.attendance = attendance;
    }

    // The overall level is the most serious level given by any rule.
    public int getRiskLevel() {

        int overall = RiskRule.LOW;

        for (int i = 0; i < rules.length; i++) {
            int level = rules[i].evaluate(averageMark, attendance);

            if (level > overall) {
                overall = level;
            }
        }

        return overall;
    }

    public String getRiskLevelName() {
        return RiskRule.levelName(getRiskLevel());
    }

    // Check student risk level
    public void checkRisk() {

        System.out.println(
            "Risk Level: " + getRiskLevelName()
        );
    }

    // Show how each rule rated the student.
    public void explainRisk() {

        for (int i = 0; i < rules.length; i++) {
            System.out.println(
                " - " + rules[i].describeResult(averageMark, attendance)
            );
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(
            "Enter average mark: "
        );

        double averageMark =
            scanner.nextDouble();

        System.out.print(
            "Enter attendance percentage: "
        );

        double attendance =
            scanner.nextDouble();

        // Create RiskAssessment object
        RiskAssessment assessment =
            new RiskAssessment(
                averageMark,
                attendance
            );

        // Check risk level
        assessment.checkRisk();

        scanner.close();
    }
}
