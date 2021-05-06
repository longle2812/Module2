public abstract class FurnitureAbstractFactory {
    public abstract Chair createChair(String id, String color, double price, double weight, String type);
    public abstract Table createTable(String id, String color, double price, double weight, String brand);
}
