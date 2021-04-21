public class CanBo extends CBGV{
    private String name;
    private String dob;
    private String hometown;

    public CanBo(String name, String dob, String hometown) {
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
    }

    public CanBo() {
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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", hometown='" + hometown + '\'' +
                '}';
    }
}
