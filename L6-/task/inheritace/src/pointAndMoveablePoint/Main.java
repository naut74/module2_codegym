package pointAndMoveablePoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        MoveablePoint moveablePoint = new MoveablePoint(2, 3, 1, 1);

        moveablePoint.move();

        System.out.println(point);
        System.out.println(moveablePoint);
    }
}
