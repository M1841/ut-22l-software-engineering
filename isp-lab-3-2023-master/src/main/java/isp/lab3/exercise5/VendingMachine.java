package isp.lab3.exercise5;

import java.util.HashMap;

public class VendingMachine {
    private HashMap<Integer, String> products;
    private int coins;

    public void displayProducts() {
        this.products.forEach((key, value) -> {
            System.out.printf("%3d%20s\n", key, value);
        });
    }

    public void insertCoin(int value) {
        this.coins += value;
    }

    public String selectProduct(int id) {
        return products.containsKey(id)
                ? products.get(id)
                : ("Couldn't find a product with id " + id);
    }

    public void displayCredit() {
        System.out.println("Available credit: " + coins);
    }
}
