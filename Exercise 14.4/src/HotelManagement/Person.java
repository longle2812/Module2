package HotelManagement;

public class Person {
    private String name;
    private String dob;
    private String idNumber;

    public Person() {
    }

    public Person(String name, String dob, String idNumber) {
        this.name = name;
        this.dob = dob;
        this.idNumber = idNumber;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
