package Dashboard;

import Academic.AcademicPerformance;
import Notification.EmailNotification;
import Notification.Notifiable;
import Notification.RiskAlertService;
import Notification.SMSNotification;
import RiskDetectionAndAssessment.RiskAssessment;
import student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Week 10: Swing dashboard for the Academic Risk Detection System.
 *
 * JFrame  = the window
 * JPanel  = groups of components (form panel, button panel)
 * Layouts = BorderLayout for the window, GridLayout for the form
 * Events  = ActionListener on each button
 * Data    = ArrayList<Student>
 *
 * Run: java -cp out Dashboard.RiskDashboard
 */
public class RiskDashboard {

    private final ArrayList<Student> students = new ArrayList<>();

    private final JFrame frame = new JFrame("Academic Risk Detection Dashboard");
    private final JTextField nameField = new JTextField(15);
    private final JTextField numberField = new JTextField(15);
    private final JTextField marksField = new JTextField(15);
    private final JTextField attendanceField = new JTextField(15);
    private final JTextArea outputArea = new JTextArea(14, 44);

    public RiskDashboard() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Form: 4 rows x 2 columns (label, field)
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        form.add(new JLabel("Student name:"));
        form.add(nameField);
        form.add(new JLabel("Student number:"));
        form.add(numberField);
        form.add(new JLabel("Marks (comma separated):"));
        form.add(marksField);
        form.add(new JLabel("Attendance (%):"));
        form.add(attendanceField);

        // Buttons
        JButton addButton = new JButton("Add Student");
        JButton clearButton = new JButton("Clear");
        JButton searchButton = new JButton("Search by Number");
        JButton alertButton = new JButton("Send Risk Alert");

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(addButton);
        buttons.add(clearButton);
        buttons.add(searchButton);
        buttons.add(alertButton);

        outputArea.setEditable(false);

        frame.add(form, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputs();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        alertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAlert();
            }
        });

        refresh();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ---------- Event handlers ----------

    private void addStudent() {

        String name = nameField.getText().trim();
        String number = numberField.getText().trim();

        if (name.isEmpty() || number.isEmpty()) {
            showMessage("Enter the student name and student number.");
            return;
        }

        if (findByNumber(number) != null) {
            showMessage("A student with that student number already exists.");
            return;
        }

        double[] marks = parseMarks(marksField.getText());
        if (marks == null) {
            showMessage(
                "Enter one or more marks between 0 and 100, separated by commas."
            );
            return;
        }

        double attendance = parseAttendance(attendanceField.getText());
        if (Double.isNaN(attendance)) {
            showMessage("Attendance must be a number between 0 and 100.");
            return;
        }

        double average = AcademicPerformance.calculateAverage(marks);

        students.add(new Student(name, number, average, attendance));
        refresh();
        clearInputs();
    }

    private void searchStudent() {

        String number = JOptionPane.showInputDialog(
            frame,
            "Enter the student number:"
        );

        if (number == null) {
            return; // Cancel pressed
        }

        Student found = findByNumber(number.trim());

        if (found == null) {
            showMessage("No student found with number " + number.trim() + ".");
        } else {
            showMessage(summary(found));
        }
    }

    private void sendAlert() {

        String number = JOptionPane.showInputDialog(
            frame,
            "Send a risk alert for which student number?"
        );

        if (number == null) {
            return;
        }

        Student found = findByNumber(number.trim());

        if (found == null) {
            showMessage("No student found with number " + number.trim() + ".");
            return;
        }

        // Interface-based polymorphism (Week 9): same call, different channels.
        Notifiable[] channels = {
            new EmailNotification(found.getName()),
            new SMSNotification(found.getName())
        };

        RiskAlertService.sendAlert(found, channels);

        showMessage(
            "Alert sent (simulated) by email and SMS:\n"
            + RiskAlertService.buildMessage(found)
        );
    }

    // ---------- Helpers ----------

    private Student findByNumber(String number) {

        for (Student student : students) {
            if (student.getStudentNumber().equalsIgnoreCase(number)) {
                return student;
            }
        }
        return null;
    }

    private String summary(Student student) {

        RiskAssessment assessment = new RiskAssessment(
            student.getAverageMark(),
            student.getAttendance()
        );

        return student.describe()
            + String.format(
                " | Avg: %.2f | Attendance: %.1f%% | %s",
                student.getAverageMark(),
                student.getAttendance(),
                assessment.getRiskLevelName()
            );
    }

    private void refresh() {

        outputArea.setText("");

        if (students.isEmpty()) {
            outputArea.append("No students added yet.\n");
            return;
        }

        for (Student student : students) {
            outputArea.append(summary(student) + "\n");
        }
    }

    private void clearInputs() {
        nameField.setText("");
        numberField.setText("");
        marksField.setText("");
        attendanceField.setText("");
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    /**
     * Converts "70, 55, 82" into {70, 55, 82}.
     * Returns null if the text is blank, not numeric, or any mark is outside 0-100.
     */
    public static double[] parseMarks(String text) {

        if (text == null || text.isBlank()) {
            return null;
        }

        String[] parts = text.split(",", -1);
        double[] marks = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                marks[i] = Double.parseDouble(parts[i].trim());
            } catch (NumberFormatException e) {
                return null;
            }

            if (marks[i] < 0 || marks[i] > 100) {
                return null;
            }
        }

        return marks;
    }

    /**
     * Converts text to an attendance percentage.
     * Returns NaN if the text is not a number between 0 and 100.
     */
    public static double parseAttendance(String text) {

        try {
            double value = Double.parseDouble(text.trim());

            if (value < 0 || value > 100) {
                return Double.NaN;
            }
            return value;

        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {

        if (GraphicsEnvironment.isHeadless()) {
            System.out.println(
                "No display available. Run this on a desktop, "
                + "or use the console version: java -cp out main"
            );
            return;
        }

        // Swing components should be created on the event dispatch thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RiskDashboard();
            }
        });
    }
}
