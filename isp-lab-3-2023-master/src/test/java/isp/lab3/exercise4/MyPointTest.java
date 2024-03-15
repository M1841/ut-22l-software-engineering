package isp.lab3.exercise4;

import org.junit.Assert;
import org.junit.Test;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(1, 1, 1);

        Assert.assertEquals(Math.sqrt(3), p1.distance(p2), 0);
        Assert.assertEquals(Math.sqrt(3), p1.distance(1, 1, 1), 0);
    }
}