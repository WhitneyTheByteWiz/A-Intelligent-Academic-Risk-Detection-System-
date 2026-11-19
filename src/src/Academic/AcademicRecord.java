package Academic;

public class AcademicRecord {

    private double averageMark;

    public AcademicRecord(double averageMark) {
        if (averageMark < 0 || averageMark > 100) {
            throw new IllegalArgumentException(
                "Average mark must be between 0 and 100."
            );
        }
        this.averageMark = averageMark;
    }

    public void displayAcademicRecord() {
        System.out.println("Average Mark: " + averageMark);
    }

    public double getAverageMark() {
        return averageMark;
    }
}
