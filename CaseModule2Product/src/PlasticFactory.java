public class PlasticFactory extends FurnitureAbstractFactory {

    @Override
    public PlasticChair createChair() {
        return new PlasticChair();
    }

    @Override
    public PlasticTable createTable(String id, String color, double price, double weight, String brand) {
        return new PlasticTable(id, color, price, weight, brand);
    }
}
