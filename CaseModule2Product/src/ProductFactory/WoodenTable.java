package ProductFactory;

public class WoodenTable extends Table {
    public WoodenTable() {
    }

    public WoodenTable(String id, String color, double price, double weight, String brand) {
        super(id, color, price, weight, brand);
    }

    @Override
    public String toString() {
        return "Wooden Table{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", brand='" + super.getBrand() + '\'' +
                '}';
    }
}
