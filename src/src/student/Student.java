package student;

import Academic.AcademicRecord;
import Attendance.AttendanceRecord;

/**
 * Represents one student and the student's academic and attendance records.
 */
public class Student {

    private String studentName;
    private String studentNumber;
    private AcademicRecord academicRecord;
    private AttendanceRecord attendanceRecord;

    public Student(
        String studentName,
        String studentNumber,
        double averageMark,
        double attendancePercentage
    ) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.academicRecord = new AcademicRecord(averageMark);
        this.attendanceRecord = new AttendanceRecord(
            studentNumber,
            attendancePercentage
        );
    }

    public String getStudentName() {
        return studentName;
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
}
