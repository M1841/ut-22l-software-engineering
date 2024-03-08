package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 90 + 10);
        }

        return array;
    }

    public static int[] findMinAndMax(int[] array) {
        int[] min_max = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        for(int element: array) {
            if(min_max[0] > element) {
                min_max[0] = element;
            }

            if(min_max[1] < element) {
                min_max[1] = element;
            }
        }

        return min_max;
    }

    public static void main(String[] args) {

        int size = (int)(Math.random() * 90 + 10);

        int[] array = getArrayOfRandomNumbers(size);

        int[] min_max = findMinAndMax(array);

        System.out.println("Min is: " + min_max[0]);
        System.out.println("Max is: " + min_max[1]);
    }
}
