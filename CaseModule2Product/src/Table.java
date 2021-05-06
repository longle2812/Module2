public class Table extends Product{
    private String brand;
    public Table() {
    }

    public Table(String id, String color, double price, double weight, String brand) {
        super(id, color, price, weight);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                "brand='" + brand + '\'' +
                '}';
    }
}
