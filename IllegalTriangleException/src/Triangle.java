public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 > side2 + side3) {
            throw new IllegalTriangleException(side1, side2, side3);
        } else if (side2 > side1 + side3) {
            throw new IllegalTriangleException(side2, side1, side3);
        } else if (side3 > side1 + side2) {
            throw new IllegalTriangleException(side3, side1, side2);
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public double getside1() {
        return side1;
    }

    public void setside1(double side1) {
        this.side1 = side1;
    }

    public double getside2() {
        return side2;
    }


    public void setside2(double side2) {
        this.side2 = side2;
    }

    public double getside3() {
        return side3;
    }

    public void setside3(double side3) {
        this.side3 = side3;
    }
}
