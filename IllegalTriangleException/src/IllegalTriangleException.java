public class IllegalTriangleException extends Exception{
    private static final double side = 1.0;

    public IllegalTriangleException (double side) {
        super(side + " is smaller than 0");
    }
    public IllegalTriangleException (double side, double side2, double side3){
        super(side +" is larger than "+ side2+ " + " +side3);
    }
}
