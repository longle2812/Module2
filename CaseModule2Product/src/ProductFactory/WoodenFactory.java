package ProductFactory;


public class WoodenFactory extends FurnitureAbstractFactory {

    @Override
    public Chair createChair(String id, String color, double price, double weight, String type) {
        return new WoodenChair(id, color, price, weight, type);
    }

    @Override
    public Table createTable(String id, String color, double price, double weight, String brand) {
        return new WoodenTable(id, color, price, weight, brand);
    }
}
