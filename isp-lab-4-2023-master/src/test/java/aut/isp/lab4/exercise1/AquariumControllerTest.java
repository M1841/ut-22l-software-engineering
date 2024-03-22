package aut.isp.lab4.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
    @Test
    public void testMethods() {
        AquariumController aquariumController = new AquariumController(
                "ACME", "AC20", 8.50f
        );
        aquariumController.setCurrentTime(8.51f);

        Assert.assertEquals(
                8.51f, aquariumController.getCurrentTime(), 0
        );

        String expectedString = "{\n\tmanufacturer = \"ACME\",\n\tmodel = " +
                "\"AC20\",\n\tcurrentTime = 8.51\n}";

        Assert.assertEquals(expectedString, aquariumController.toString());
    }
}
