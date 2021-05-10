package ProductFactory;

public class PlasticTable extends Table {
    public PlasticTable() {
    }

    public PlasticTable(String id, String color, double price, double weight, String brand) {
        super(id, color, price, weight, brand);
    }

    @Override
    public String toString() {
        return "Plastic Table{" +
                "id='" + super.getId() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                ", brand='" + super.getBrand() + '\'' +
                '}';
    }
}
