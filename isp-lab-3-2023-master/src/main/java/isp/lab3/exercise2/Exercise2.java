package isp.lab3.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 6, "green");

        System.out.println("rectangle: Rectangle = {" +
                "\n\tlength: int = " + rectangle.getLength() +
                ",\n\twidth: int = " + rectangle.getWidth() +
                ",\n\tcolor: String = \"" + rectangle.getColor() + "\"\n}");

        System.out.println("Perimeter = " + rectangle.getPerimeter());
        System.out.println("Area = " + rectangle.getArea());
    }
}
