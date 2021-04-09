public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(double radius, String color) {
        super(radius, color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height= " + height +
                ", " +
                "radius= " +super.getRadius()+
                ", " +
                "color= " +super.getColor()+
                ", "+
                "Area= " + super.getArea()+
                ", " +
                "Volume= " +this.getVolume()+
                '}';
    }
}
