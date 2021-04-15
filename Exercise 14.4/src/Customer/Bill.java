package Customer;

public class Bill {
    private Customer customer;
    private double oldIndex;
    private double newIndex;
    private double moneyToPay;

    public Bill() {
    }

    public Bill(Customer customer, double oldIndex, double newIndex, double moneyToPay) {
        this.customer = customer;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.moneyToPay = moneyToPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(double oldIndex) {
        this.oldIndex = oldIndex;
    }

    public double getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(double newIndex) {
        this.newIndex = newIndex;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(double moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", oldIndex=" + oldIndex +
                ", newIndex=" + newIndex +
                ", moneyToPay=" + moneyToPay +
                '}';
    }
}
