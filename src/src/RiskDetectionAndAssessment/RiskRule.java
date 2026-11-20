package RiskDetectionAndAssessment;

/**
 * Week 9: abstract class. Every risk rule must say how it rates a student
 * (evaluate) but shares the same level constants and helper methods.
 * You cannot write new RiskRule() - only concrete subclasses can be created.
 */
public abstract class RiskRule {

    public static final int LOW = 0;
    public static final int MODERATE = 1;
    public static final int HIGH = 2;

    // Each subclass supplies its own rule.
    public abstract int evaluate(double averageMark, double attendance);

    public abstract String getRuleName();

    // Shared concrete method (like Shape.printArea in the Week 9 lab).
    public String describeResult(double averageMark, double attendance) {
        return getRuleName() + ": " + levelName(evaluate(averageMark, attendance));
    }

    public static String levelName(int level) {
        switch (level) {
            case HIGH:
                return "HIGH RISK";
            case MODERATE:
                return "MODERATE RISK";
            default:
                return "LOW RISK";
        }
    }
}
