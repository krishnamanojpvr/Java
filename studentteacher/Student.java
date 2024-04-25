package studentteacher;

public class Student extends Person {
    public boolean attandance;
    public Student(String name, int age) {
        super(name, age);
    }
    public void setAttendance(boolean attandance){
        this.attandance = true;
    }
}