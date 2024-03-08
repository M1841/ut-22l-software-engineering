package lab.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mihai.hulea
 */
public class ExampleTest {

    @Test
    public void testAdd() {
        assertEquals("Should add 2 numbers", 30, Example.add(10,20));
    }

    @Test
    public void testSubtract() {
        assertEquals("Should subtract 2 numbers", 5, Example.subtract(15,10));
    }

    @Test
    public void testMultiply() {
        assertEquals("Should multiply 2 numbers", 12, Example.multiply(3, 4));
    }
}
