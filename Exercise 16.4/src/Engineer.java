public class Engineer extends Person{
    private String branch;

    public Engineer() {
    }

    public Engineer(String name, String dob, String sex, String address, String branch) {
        super(name, dob, sex, address);
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
        return "Engineer{" +
                "branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
