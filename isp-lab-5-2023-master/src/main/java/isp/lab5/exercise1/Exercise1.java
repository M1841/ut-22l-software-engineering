package isp.lab5.exercise1;

import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {
        Address address = new Address("Observatorului", "Cluj-Napoca");
        Customer customer = new Customer("Mihai", "+40***", address);
        Product[] products = {
                new Product("SSD", 299.99, ProductCategory.ELECTRONICS),
                new Product("RAM", 149.99, ProductCategory.ELECTRONICS)
        };
        Double totalPrice = Arrays
                .stream(products)
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
        Order order = new Order(totalPrice, products, customer);

        System.out.println(order);
    }
}
