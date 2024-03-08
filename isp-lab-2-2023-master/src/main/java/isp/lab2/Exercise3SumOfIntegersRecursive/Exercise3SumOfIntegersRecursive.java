package isp.lab2.Exercise3SumOfIntegersRecursive;

import java.util.Scanner;

public class Exercise3SumOfIntegersRecursive {


    /**
     * This method will return the sum of the first n integers
     * @param n
     * @return
     */
    public static int sumOfIntegers(int n) {
        if(n == 1) return 1;
        return n + sumOfIntegers(n - 1);
    }

    public static int readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        System.out.println(sumOfIntegers(5));
        System.out.println(sumOfIntegers(readFromConsoleInt()));
    }
}
