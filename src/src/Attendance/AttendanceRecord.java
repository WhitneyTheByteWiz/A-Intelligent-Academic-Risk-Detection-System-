package Attendance;

public class AttendanceRecord {

    private String studentNumber;
    private double attendancePercentage;

    public AttendanceRecord(String studentNumber, double attendancePercentage) {
        if (studentNumber == null || studentNumber.isBlank()) {
            throw new IllegalArgumentException("Student number is required.");
        }
        if (attendancePercentage < 0 || attendancePercentage > 100) {
            throw new IllegalArgumentException(
                "Attendance must be between 0 and 100."
            );
        }
        this.studentNumber = studentNumber;
        this.attendancePercentage = attendancePercentage;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }
}
