package RiskDetectionAndAssessment;

public class RiskAssessment {

    double averageMark;
    double attendance;

    public RiskAssessment(
        double averageMark,
        double attendance
    ) {
        this.averageMark = averageMark;
        this.attendance = attendance;
    }

    public void checkRisk() {

        if (attendance < 60 ||
            averageMark < 50) {

            System.out.println(
                "Risk Level: HIGH RISK"
            );

        } else if (attendance < 75) {

            System.out.println(
                "Risk Level: MODERATE RISK"
            );

        } else {

            System.out.println(
                "Risk Level: LOW RISK"
            );
        }
    }
}
