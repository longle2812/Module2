package EmployeeManagement;

public class NormalWorker extends Employee{
    private String speciality;
    private int level;

    public NormalWorker(String speciality, int level) {
        this.speciality = speciality;
        this.level = level;
    }

    public NormalWorker(String id, String name, int age, String sex, String hometown, double wage, String speciality, int level) {
        super(id, name, age, sex, hometown, wage);
        this.speciality = speciality;
        this.level = level;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "NormalWorker{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", sex='" + super.getSex() + '\'' +
                ", hometown='" + super.getHometown() + '\'' +
                ", wage=" + super.getWage() +
                ",speciality='" + speciality + '\'' +
                ", level=" + level +
                '}';
    }
}
