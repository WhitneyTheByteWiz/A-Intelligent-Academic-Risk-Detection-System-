# Week-by-week alignment: Intelligent Academic Risk Detection System

This file shows where each CS350 week's concept appears in the project, so the team can explain it in a demonstration.

| Week | Concept | Where it is used in the project |
|---|---|---|
| 1 | Project initiation, proposal, GitHub | Repository, README, team table, `docs/mins/` (not code) |
| 2 | Control structures | `main.java`: `do-while` menu loop, `switch` on menu choice, validation `while` loops; `AcademicPerformance.checkPerformance` and the rules use `if / else if` |
| 3 | Methods | `main.java`: `addStudent`, `enterMarks`, `calculateAverage`, `selectStudent`, `checkRisk`, `displayFullReport`, `sendRiskAlert`; `AcademicPerformance.calculateAverage` returns a value |
| 4 | Arrays / collections | `Student[] students` and `double[] marks` in `main.java`; `RiskRule[] rules` in `RiskAssessment`; `Notifiable[] channels` |
| 6 | Classes and objects | `Student`, `AcademicRecord`, `AttendanceRecord`; each `Student` keeps its own state |
| 7 | Encapsulation, constructors, validation | Private fields everywhere; constructors reject blank names/numbers and marks or attendance outside 0-100 (`IllegalArgumentException`) |
| 8 | Inheritance and overriding | `Student extends Person`, `super(studentName)` first in the constructor, `@Override describe()`. IS-A: a student is a person. `Student` HAS-A `AcademicRecord` and `AttendanceRecord` (composition) |
| 9 | Polymorphism, abstract classes, interfaces | **Abstract class:** `RiskRule` with `AcademicRiskRule` and `AttendanceRiskRule`; `RiskAssessment` loops over a `RiskRule[]`. **Interface:** `Notifiable` with `EmailNotification` and `SMSNotification`, used through `Notifiable[]` in `RiskAlertService` |
| 10 | Swing GUI, layout, events | `Dashboard.RiskDashboard`: `JFrame`, `JPanel`, `BorderLayout`, `GridLayout(4,2,8,8)`, `ActionListener` on each button, `ArrayList<Student>`, `JTextArea` refreshed after each add, blank-input and duplicate-ID messages, inputs cleared after a successful add, search by student number |

Week 5 has no materials in the uploaded course folder, so it is not mapped here.

## Behaviour that must not change

The risk thresholds are the team's development criteria, not institutional policy:

- HIGH: average below 50 OR attendance below 60.
- MODERATE: attendance below 75 (and not high).
- LOW: average at least 50 AND attendance at least 75.

The Week 9 refactoring into rules was checked against the original `if / else` logic over every mark and attendance pair from 0 to 100 in steps of 0.5 (40,401 combinations) and gives identical results.

## Known gaps / future work

- Meeting minutes in `docs/mins/` exist for Weeks 1-3 only.
- `DataStorage` and `CourseResult` are still placeholders.
- The console app and the GUI do not share data.
- Alerts are simulated; recipients are student names because the system holds no contact details.
