public class WoodenFactory extends FurnitureAbstractFactory {

    @Override
    public Chair createChair() {
        return new WoodenChair();
    }

    @Override
    public Table createTable(String id, String color, double price, double weight, String brand) {
        return new WoodenTable();
    }
}
