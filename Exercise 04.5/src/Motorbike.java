public class Motorbike extends Vehicle{
    private double capacity;

    public Motorbike() {
    }

    public Motorbike(double capacity) {
        this.capacity = capacity;
    }

    public Motorbike(String brand, int year, double price, String color, double capacity) {
        super(brand, year, price, color);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "brand= " + super.getBrand()+
                ", year= " + super.getYear() +
                ", price= " +super.getPrice()+
                ", color= " +super.getColor()+
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
