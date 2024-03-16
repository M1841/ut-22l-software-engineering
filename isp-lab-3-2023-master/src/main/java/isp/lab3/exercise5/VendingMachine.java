package isp.lab3.exercise5;

import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {
    private final HashMap<Integer, String> products;
    private int coins;

    public VendingMachine() {
        HashMap<Integer, String> products = new HashMap<>();
        products.put(1, "A");
        products.put(2, "B");
        products.put(3, "C");
        products.put(4, "D");

        this.products = products;
        this.coins = 0;
    }

    public void displayProducts() {
        System.out.printf("%3s%20s\n", "ID", "Product");
        this.products.forEach((key, value) -> System.out.printf("%3d%20s\n", key, value));
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

    public void userMenu() {
        System.out.println("Choose an action:" +
                "\n1. Display Products" +
                "\n2. Insert Coins" +
                "\n3. Display Credit" +
                "\n4. Choose Product" +
                "\n5. Exit\n");

        Scanner scanner = new Scanner(System.in);
        String action;
        do {
            System.out.print("Your choice: ");

            action = scanner.next();

            switch (action) {
                case "1": {
                    this.displayProducts();
                    break;
                }
                case "2": {
                    boolean isValid = false;
                    int coins = 0;

                    while(!isValid) {
                        System.out.print("Amount of coins: ");

                        try {
                            coins = Integer.parseInt(scanner.next());
                            isValid = true;
                        } catch(NumberFormatException e) {
                            System.out.println("Invalid input, type a number");
                        }
                    }

                    this.insertCoin(coins);

                    break;
                }
                case "3": {
                    this.displayCredit();
                    break;
                }
                case "4": {
                    boolean isValid = false;
                    int id = 0;

                    while(!isValid) {
                        System.out.print("Product id: ");

                        try {
                            id = Integer.parseInt(scanner.next());
                            isValid = true;
                        } catch(NumberFormatException e) {
                            System.out.println("Invalid input, type a number");
                        }
                    }

                    System.out.println(this.selectProduct(id));
                    break;
                }
                case "5": {
                    System.out.println("See you later!");
                    break;
                }
                default: {
                    System.out.println("Invalid input, type a number between 1 and 5");
                }
            }
        } while(!action.equals("5"));
    }

    public int getCoins() {
        return coins;
    }
}
