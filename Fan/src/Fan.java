public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public Fan() {
    }

    public Fan(int speed,boolean on,double radius,String color){
        this.speed = speed;
        this.color = color;
        this.radius = radius;
        this.on = on;
    }

    public String toString(){
        if (this.on) {
            return "fan is on with speed: " + this.speed+", color: " + this.color+", radius: "+this.radius;
        }
        else return "fan is off with speed: " + this.speed+", color: " + this.color+", radius: "+this.radius;
    }

    
}
