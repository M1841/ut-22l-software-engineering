package aut.isp.lab4.exercise2;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FishFeederTest {
    @Test
    public void testFeed() {
        FishFeeder fishFeeder = new FishFeeder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fishFeeder.feed();
        Assert.assertEquals(
                "Feeder is empty\r\n", outputStream.toString()
        );

        fishFeeder.fillUp();
        outputStream.reset();

        fishFeeder.feed();
        Assert.assertEquals(0, fishFeeder.getMeals());
        Assert.assertEquals(
                "The fish are fed\r\n", outputStream.toString()
        );
    }

    @Test
    public void testFillUp() {
        FishFeeder fishFeeder = new FishFeeder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fishFeeder.fillUp();
        Assert.assertEquals(1, fishFeeder.getMeals());
        Assert.assertEquals(
                "Feeder refilled\r\n", outputStream.toString()
        );

        for(int i = 1; i < 14; i++) {
            fishFeeder.fillUp();
        }
        outputStream.reset();

        fishFeeder.fillUp();
        Assert.assertEquals(
                "Feeder is full\r\n", outputStream.toString()
        );
    }
}
