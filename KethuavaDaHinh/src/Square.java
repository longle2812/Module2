public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public Square() {
        super.setHeight(1.0);
        super.setWidth(1.0);
    }

    public Square(double side, String color, boolean filled){
        setSide(side);
        super.setColor(color);
        super.setFilled(filled);
    }
    public double getSize() {
        return super.getHeight();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    public void setHeight(double size) {
        super.setHeight(size);
    }

    public void setWidth(double size) {
        super.setWidth(size);
    }

    public String toString() {
        return "A Square with side=" + getSize() + ", which is a subclass of " + super.toString();
    }
}
