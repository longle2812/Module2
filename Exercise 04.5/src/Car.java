public class Car extends Vehicle{
    private int seat;
    private String engine;

    public Car() {
    }

    public Car(int seat, String engine) {
        this.seat = seat;
        this.engine = engine;
    }

    public Car(String brand, int year, double price, String color, int seat, String engine) {
        super(brand, year, price, color);
        this.seat = seat;
        this.engine = engine;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand= " + super.getBrand()+
                ", year= " + super.getYear() +
                ", price= " +super.getPrice()+
                ", color= " +super.getColor()+
                ", seat=" + seat +
                ", engine='" + engine + '\'' +
                '}';
    }
}
