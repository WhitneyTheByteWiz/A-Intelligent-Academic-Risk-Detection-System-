package Academic;

public class AcademicRecord {

    private double averageMark;

    public AcademicRecord(double averageMark) {
        this.averageMark = averageMark;
    }

    public void displayAcademicRecord() {
        System.out.println("Average Mark: " + averageMark);
    }

    public double getAverageMark() {
        return averageMark;
    }
}
