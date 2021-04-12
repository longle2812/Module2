public class Shape {
    private String color;
    private boolean filled;
    private String isFilled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    @Override
    public String toString() {
        if (filled) {
            isFilled = "filled";
        } else isFilled = "not filled";
        return "A Shape with color of " + this.color + " and "+isFilled;
    }
}
