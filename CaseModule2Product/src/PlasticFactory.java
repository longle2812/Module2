public class PlasticFactory extends FurnitureAbstractFactory {

    @Override
    public PlasticChair createChair(String id, String color, double price, double weight, String type) {
        return new PlasticChair(id, color, price, weight, type);
    }

    @Override
    public PlasticTable createTable(String id, String color, double price, double weight, String brand) {
        return new PlasticTable(id, color, price, weight, brand);
    }
}
