package isp.lab3.exercise5;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VendingMachineTest {

    @Test
    public void testDisplayProducts() {
        VendingMachine vm = new VendingMachine();
        String expected = String.format("%3s%20s\n", "ID", "Product")
                + String.format("%3d%20s\n", 1, "A")
                + String.format("%3d%20s\n", 2, "B")
                + String.format("%3d%20s\n", 3, "C")
                + String.format("%3d%20s\n", 4, "D");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        vm.displayProducts();

        Assert.assertEquals(expected, outputStream.toString());
    }

    @Test
    public void testInsertCoin() {
        VendingMachine vm = new VendingMachine();
        vm.insertCoin(10);
        Assert.assertEquals(10, vm.getCoins());
    }

    @Test
    public void testSelectProduct() {
        VendingMachine vm = new VendingMachine();

        String product1 = vm.selectProduct(1);
        Assert.assertEquals("A", product1);

        String product2 = vm.selectProduct(99);
        Assert.assertEquals("Couldn't find a product with id 99", product2);
    }
}