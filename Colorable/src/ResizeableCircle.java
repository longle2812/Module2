public class ResizeableCircle extends Circle
        implements Resizeable {

    public ResizeableCircle() {
    }

    public ResizeableCircle(double radius) {
        super(radius);
    }

    public ResizeableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public ResizeableCircle resize(double percent) {
        return new ResizeableCircle(getRadius()*percent, getColor(), true);
    }
}