import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String hometown;
    private String grade;
    private double mark;

    public Student() {

    }

    public Student(int id, String name, String hometown, String grade, double mark) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.grade = grade;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", grade='" + grade + '\'' +
                ", mark=" + mark +
                '}';
    }
}
