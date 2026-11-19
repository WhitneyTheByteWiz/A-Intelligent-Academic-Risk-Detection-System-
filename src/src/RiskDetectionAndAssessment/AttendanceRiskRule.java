package RiskDetectionAndAssessment;

/** Attendance below 60% is HIGH risk; below 75% is MODERATE risk. */
public class AttendanceRiskRule extends RiskRule {

    @Override
    public int evaluate(double averageMark, double attendance) {
        if (attendance < 60) {
            return HIGH;
        } else if (attendance < 75) {
            return MODERATE;
        }
        return LOW;
    }

    @Override
    public String getRuleName() {
        return "Attendance rule";
    }
}
