public abstract class FurnitureAbstractFactory {
    public abstract Chair createChair();
    public abstract Table createTable(String id, String color, double price, double weight, String brand);
}
