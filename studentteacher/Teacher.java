package studentteacher;
import java.util.List;

public class Teacher extends Person {
    private List<Student> students;

    public Teacher(List<Student> students) {
        super(null, 0);
        this.students = students;
    }

    // Getters and setters for students

    public void markAttendance(List<Student> students) {
        for (Student student : students) {
            student.setAttendance(true);
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("John", 20);
        Student student2 = new Student("Jane", 21);
        Teacher teacher = new Teacher(List.of(student1, student2));
        teacher.markAttendance(teacher.students);

        for (Student student : teacher.students) {
            System.out.println(student.getName() + " has attendance: " + student.attandance);
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}