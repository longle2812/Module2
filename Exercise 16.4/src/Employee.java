public class Employee extends Person{
    private String work;

    public Employee(String name, String dob, String sex, String address, String work) {
        super(name, dob, sex, address);
        this.work = work;
    }

    public Employee() {
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "work='" + work + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
