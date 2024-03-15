package isp.lab3.exercise4;

import org.jetbrains.annotations.NotNull;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        this.x = this.y = this.z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(int x, int y, int z) {
        return Math.sqrt((Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2)));
    }

    public double distance(@NotNull MyPoint other) {
        return Math.sqrt((Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2)));
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
