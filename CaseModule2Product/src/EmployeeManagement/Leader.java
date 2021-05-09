package EmployeeManagement;

public class Leader extends Employee{
    private String branch;

    public Leader() {
    }

    public Leader(String id, String name, int age, String sex, String hometown, double wage, String branch) {
        super(id, name, age, sex, hometown, wage);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "EmployeeManagement.Leader{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", sex='" + super.getSex() + '\'' +
                ", hometown='" + super.getHometown() + '\'' +
                ", wage=" + super.getWage() +
                ", branch='" + branch + '\'' +
                '}';
    }
}
