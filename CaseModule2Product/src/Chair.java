public class Chair extends Product{
    private String type; //living room, kitchen, work

    public Chair() {
    }

    public Chair(String id, String color, double price, double weight, String type) {
        super(id, color, price, weight);
        this.type = type;
    }

}
