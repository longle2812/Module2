package ProductFactory;

public class WoodenChair extends Chair {
    public WoodenChair() {
    }

    public WoodenChair(String id, String color, double price, double weight, String type) {
        super(id, color, price, weight, type);
    }

    @Override
    public String toString() {
        return "Wooden Chair{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", type='" + super.getType() + '\'' +
                '}';
    }
}
