package ProductFactory;


public class Chair extends Product {
    private String type; //living room, kitchen, work

    public Chair() {
    }

    public Chair(String id, String color, double price, double weight, String type) {
        super(id, color, price, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductFactory.Chair{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", type='" + type + '\'' +
                '}';
    }
}
