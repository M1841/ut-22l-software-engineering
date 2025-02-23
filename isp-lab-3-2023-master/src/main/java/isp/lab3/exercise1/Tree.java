package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree() {
        this.height = 15;
    }

    public void grow(int meters) {
        if(meters >= 1) this.height += meters;
    }

    @Override
    public String toString() {
        return String.valueOf(this.height);
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
