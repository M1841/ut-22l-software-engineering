package isp.lab5.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {
  @Test
  public void testLaptopCharge() {
    Chargeable laptop = new Laptop();
    int oneHour = 60;
    laptop.charge(oneHour);
    Assert.assertEquals(30, laptop.getBatteryLevel());
  }

  @Test
  public void testPhoneCharge() {
    Chargeable phone = new SmartPhone();
    int oneHour = 60;
    phone.charge(oneHour);
    Assert.assertEquals(60, phone.getBatteryLevel());
  }

  @Test
  public void testWatchCharge() {
    Chargeable watch = new SmartWatch();
    int oneHour = 60;
    watch.charge(oneHour);
    Assert.assertEquals(100, watch.getBatteryLevel());
  }
}
