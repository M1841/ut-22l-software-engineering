package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(1, 1, 1);

        System.out.printf("Distance between %s and %s = %.2f",
                p1, p2, p1.distance(p2));
    }
}
