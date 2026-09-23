package src.Attendance;

public class AttendanceRecord {

    private String studentNumber;
    private double attendancePercentage;

    public AttendanceRecord(String studentNumber, double attendancePercentage) {
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