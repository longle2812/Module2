package Customer;

public class Customer {
    private String name;
    private String homeID;
    private String meterID;

    public Customer() {
    }

    public Customer(String name, String homeID, String meterID) {
        this.name = name;
        this.homeID = homeID;
        this.meterID = meterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeID() {
        return homeID;
    }

    public void setHomeID(String homeID) {
        this.homeID = homeID;
    }

    public String getMeterID() {
        return meterID;
    }

    public void setMeterID(String meterID) {
        this.meterID = meterID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", homeID='" + homeID + '\'' +
                ", meterID='" + meterID + '\'' +
                '}';
    }
}
