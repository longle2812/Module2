public class Truck extends Vehicle{
    private double weight;

    public Truck(double weight) {
        this.weight = weight;
    }

    public Truck(String brand, int year, double price, String color, double weight) {
        super(brand, year, price, color);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand= " + super.getBrand()+
                ", year= " + super.getYear() +
                ", price= " +super.getPrice()+
                ", color= " +super.getColor()+
                ", weight=" + weight +
                '}';
    }
}
