public class Student {
    public int id;
    public String name;
    public String dob;
    public int mark;
    public static int totalStudent = 4;
    public static int lastID = 4;

    public Student(int id, String name, String dob, int mark) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.mark = mark;
    }

    public Student() {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
