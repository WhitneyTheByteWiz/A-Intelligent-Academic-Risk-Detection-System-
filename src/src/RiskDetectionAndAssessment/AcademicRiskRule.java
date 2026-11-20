package RiskDetectionAndAssessment;

/** Average mark below 50 is HIGH risk. */
public class AcademicRiskRule extends RiskRule {

    @Override
    public int evaluate(double averageMark, double attendance) {
        if (averageMark < 50) {
            return HIGH;
        }
        return LOW;
    }

    @Override
    public String getRuleName() {
        return "Academic rule";
    }
}
