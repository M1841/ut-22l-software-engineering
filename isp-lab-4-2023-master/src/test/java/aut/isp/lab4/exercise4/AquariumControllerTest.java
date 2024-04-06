package aut.isp.lab4.exercise4;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AquariumControllerTest {
    @Test
    public void testMethods() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FishFeeder fishFeeder = new FishFeeder("ACME", "F500");

        AquariumController aquariumController = new AquariumController(
                fishFeeder, "ACME", "AC20", 2.0f, 5.0f);

        aquariumController.setCurrentTime(7.0f);
        Assert.assertEquals("The light is on\r\n", outputStream.toString());

        outputStream.reset();
        aquariumController.setCurrentTime(8.0f);
        Assert.assertEquals("The light is off\r\n", outputStream.toString());
    }
}
