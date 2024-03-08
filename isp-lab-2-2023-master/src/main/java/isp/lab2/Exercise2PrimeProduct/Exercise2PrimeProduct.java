package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     * @param n
     * @param m
     * @return
     */

    public static boolean isPrime(int x) {
        if(x < 2) return false;
        if(x == 2) return true;
        if(x % 2 == 0) return false;

        for(int i = 3; i * i < x; i++) {
            if(x % i == 0) return false;
        }

        return true;
    }

    public static long getPrimeProduct(int n, int m) {
        long product = 1;

        for(int i = n; i <= m; i++) {
            if(isPrime(i)) product *= i;
        }

        return product;
    }


    /**
     * This method should read from the console a number
     * @return the number read from the console
     */
    public static int readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readFromConsoleInt(), readFromConsoleInt()));
    }

}
