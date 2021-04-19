public class Worker extends Person{
    private String level;

    public Worker() {
    }

    public Worker(String name, String dob, String sex, String address, String level) {
        super(name, dob, sex, address);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
