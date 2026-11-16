# Intelligent Academic Risk Detection System

## Project overview

A Java console application developed for CS350 Object-Oriented Programming. It records student details, academic marks and attendance, calculates average marks, and applies rule-based criteria to display an academic risk level.

## Current capabilities

- Add up to 10 student records during one run.
- Validate student names, student numbers, marks and attendance input.
- Reject duplicate student numbers.
- Enter multiple marks and calculate the average.
- Display all recorded students.
- Select a student to view a risk assessment or full report.
- Use separate classes for student, academic record, attendance record, menu, performance checking and risk assessment.

## Important current limitations

- Student records are held in memory only. They are lost when the program exits.
- `DataStorage`, `Storage.Main`, `RiskDashboard` and `CourseResult` remain placeholders. File/database storage and a full dashboard have not been implemented.
- The current risk thresholds are development criteria, not approved institutional policy:
  - HIGH RISK: average mark below 50 OR attendance below 60%.
  - MODERATE RISK: attendance below 75%, provided the student is not high risk.
  - LOW RISK: average mark at least 50 AND attendance at least 75%.
- `RiskChecker` and `RiskAssessment` are both retained because both were part of the team's existing work. The main application uses `RiskAssessment` for its risk result.

## Project structure

```text
src/src/
├── main.java
├── Academic/
│   ├── AcademicPerformance.java
│   ├── AcademicRecord.java
│   ├── CourseResult.java
│   └── PerformanceChecker.java
├── Attendance/
│   ├── AttendanceChecker.java
│   └── AttendanceRecord.java
├── Dashboard/
│   ├── RiskDashboard.java
│   └── SystemMenu.java
├── Data/
│   └── README.md
├── RiskDetectionAndAssessment/
│   ├── RiskAssessment.java
│   └── RiskChecker.java
├── Storage/
│   ├── DataStorage.java
│   └── Main.java
└── student/
    ├── Student.java
    └── StudentValidation.java
```

## Compile and run (Fedora/Linux)

Run these commands from the repository root:

```bash
javac -d out $(find src/src -name "*.java")
java -cp out main
```

To remove generated build output:

```bash
rm -rf out
```

The project uses only the Java standard library. No external dependencies are required.

## Team

| Name | Student number |
|---|---:|
| Whitney Jr Syulikwa | 23146553 |
| Josephat Malichi | 22102578 |
| Chris Mukubu | 23998614 |
| Nokuthula Hakamata | 23144129 |
| Kangwa Chewe | 23131264 |

**Course:** CS350 - Object-Oriented Programming in Java
**Status:** Under development
