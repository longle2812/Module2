public class PlasticChair extends Chair{

    public PlasticChair(String id, String color, double price, double weight, String type) {
        super(id, color, price, weight, type);
    }

    public PlasticChair() {
    }

    public void say(){
        System.out.println("hi");
    }
}
