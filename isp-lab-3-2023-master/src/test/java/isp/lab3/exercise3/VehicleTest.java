package isp.lab3.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest{
    @Test
    public void testToString() {
        Vehicle v1 = new Vehicle("Dacia", "Logan", 150, 'B');
        String expected = "Dacia (Logan) speed 150 fuel type B";

        Assert.assertEquals(expected, v1.toString());
    }
}