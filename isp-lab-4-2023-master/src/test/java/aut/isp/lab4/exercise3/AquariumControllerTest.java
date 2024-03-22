package aut.isp.lab4.exercise3;

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
                fishFeeder, "ACME", "AC20", 9.33f, 9.35f
        );
        aquariumController.setCurrentTime(9.34f);
        Assert.assertEquals("", outputStream.toString());

        aquariumController.setCurrentTime(9.35f);
        Assert.assertEquals("", outputStream.toString());
    }
}
