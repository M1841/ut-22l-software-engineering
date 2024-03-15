package isp.lab3.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree tree = new Tree();
        tree.setHeight(10);
        tree.grow(2);
        Assert.assertEquals(12, tree.getHeight());
    }

    @Test
    public void testDoesNotShrink() {
        Tree tree = new Tree();
        tree.setHeight(10);
        tree.grow(-2);
        Assert.assertEquals(10, tree.getHeight());
    }

    @Test
    public void testToString() {
        Tree tree = new Tree();
        tree.setHeight(10);
        String treeAsStr = tree.toString();
        Assert.assertEquals("10", treeAsStr);
    }
}