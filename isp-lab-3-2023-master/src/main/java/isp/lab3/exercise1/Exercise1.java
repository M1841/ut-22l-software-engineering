package isp.lab3.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setHeight(10);
        tree.grow(2);
        System.out.println("Height from getter: " + tree.getHeight());
        System.out.println("Height from toString: " + tree.getHeight());
    }
}
