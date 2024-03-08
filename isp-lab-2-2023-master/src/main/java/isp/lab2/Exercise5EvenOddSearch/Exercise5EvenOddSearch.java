package isp.lab2.Exercise5EvenOddSearch;

import java.util.*;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {

        int[] nums = Arrays
                .stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] max_min = {Integer.MIN_VALUE, -1, Integer.MAX_VALUE, -1};

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(max_min[0] < num && num % 2 == 0) {
                max_min[0] = num;
                max_min[1] = i;
            }
            if(max_min[2] > num && num % 2 != 0) {
                max_min[2] = num;
                max_min[3] = i;
            }
        }

        return max_min;
    }

    public static String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by commas: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = readFromConsole();

        int[] result = findEvenOdd(input);

        if(result[1] == -1) System.out.println("The input contains no even numbers");
        else System.out.println("Highest even number: " + result[0] + ", found at " +
                "index: " + result[1]);
        if(result[3] == -1) System.out.println("The input contains no odd numbers");
        else System.out.println("Lowest odd number: " + result[2] + ", found at " +
                "index: " + result[3]);
    }
}
