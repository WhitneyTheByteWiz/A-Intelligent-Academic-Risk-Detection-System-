package student;

import Academic.AcademicRecord;
import Attendance.AttendanceRecord;

/**
 * Week 8: a Student IS-A Person (inherits the validated name).
 * A Student HAS-A AcademicRecord and HAS-A AttendanceRecord (composition).
 */
public class Student extends Person {

    private String studentNumber;
    private AcademicRecord academicRecord;
    private AttendanceRecord attendanceRecord;

    public Student(
        String studentName,
        String studentNumber,
        double averageMark,
        double attendancePercentage
    ) {
        super(studentName); // The parent constructor must run first.

        if (studentNumber == null || studentNumber.isBlank()) {
            throw new IllegalArgumentException("Student number is required.");
        }

        this.studentNumber = studentNumber.trim();
        this.academicRecord = new AcademicRecord(averageMark);
        this.attendanceRecord = new AttendanceRecord(
            this.studentNumber,
            attendancePercentage
        );
    }

    // Kept so existing code that calls getStudentName() still works.
    public String getStudentName() {
        return getName();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public AcademicRecord getAcademicRecord() {
        return academicRecord;
    }

    public AttendanceRecord getAttendanceRecord() {
        return attendanceRecord;
    }

    public double getAverageMark() {
        return academicRecord.getAverageMark();
    }

    public double getAttendance() {
        return attendanceRecord.getAttendancePercentage();
    }

    @Override
    public String describe() {
        return "Student: " + getName() + " (" + studentNumber + ")";
    }
}
