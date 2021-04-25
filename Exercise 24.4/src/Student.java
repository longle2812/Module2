public class Student {
    private int id;
    private String name;
    private String address;
    private int priority;
    private GradeA gradeA;
    private GradeB gradeB;
    private GradeC gradeC;

    public Student() {
    }

    public Student(int id, String name, String address, int priority) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priority = priority;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public GradeA getGradeA() {
        return gradeA;
    }

    public void setGradeA(GradeA gradeA) {
        this.gradeA = gradeA;
    }

    public GradeB getGradeB() {
        return gradeB;
    }

    public void setGradeB(GradeB gradeB) {
        this.gradeB = gradeB;
    }

    public GradeC getGradeC() {
        return gradeC;
    }

    public void setGradeC(GradeC gradeC) {
        this.gradeC = gradeC;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", priority=" + priority +
                '}';
    }
}
