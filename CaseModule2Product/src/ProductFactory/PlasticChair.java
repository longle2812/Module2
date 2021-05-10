package ProductFactory;

public class PlasticChair extends Chair {

    public PlasticChair(String id, String color, double price, double weight, String type) {
        super(id, color, price, weight, type);
    }

    public PlasticChair() {
    }

    @Override
    public String toString() {
        return "Plastic Chair{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", type='" + super.getType() + '\'' +
                '}';
    }
}
