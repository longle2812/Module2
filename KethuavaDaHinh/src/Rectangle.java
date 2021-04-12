public class Rectangle extends Shape {
    private double height, width;

    public Rectangle() {
        this.height = 1.0;
        this.width = 1.0;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle(double height, double width, String color, boolean filled) {
        this.height = height;
        this.width = width;
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return (this.width+this.height)*2;
    }

    public String toString() {
        return "A Rectangle with width= "+this.width+" and length=" +this.height+" which is a subclass of" + super.toString();
    }
}
