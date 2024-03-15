package isp.lab3.exercise2;

public class Rectangle {
    private final int length;
    private final int width;
    private String color;

    public Rectangle() {
        this.length = 2;
        this.width = 1;
        this.color = "red";
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public String getColor() {
        return this.color;
    }

    public int getPerimeter() {
        return 2 * (this.length + this.width);
    }

    public int getArea() {
        return this.length * this.width;
    }
}
