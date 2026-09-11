public class Student {

    private String studentId;
    private String name;
    private String programme;
    private int year;

    public Student(String studentId, String name, String programme, int year) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Programme: " + programme);
        System.out.println("Year: " + year);
    }
}
