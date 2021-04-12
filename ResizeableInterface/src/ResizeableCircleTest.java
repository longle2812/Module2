import java.util.Arrays;

public class ResizeableCircleTest {
    public static void main(String[] args) {
        ResizeableCircle[] circles = new ResizeableCircle[3];
        circles[0] = new ResizeableCircle(3.6);
        circles[1] = new ResizeableCircle();
        circles[2] = new ResizeableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ResizeableCircle circle : circles) {
            System.out.println(circle);
        }

        for (int i = 0; i < circles.length; i++) {
            circles[i] = circles[i].resize(2);
        }
        System.out.println("After-sorted:");
        for (ResizeableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}