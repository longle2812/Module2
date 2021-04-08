public class test {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1,1,2,2);
        moveablePoint = moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
