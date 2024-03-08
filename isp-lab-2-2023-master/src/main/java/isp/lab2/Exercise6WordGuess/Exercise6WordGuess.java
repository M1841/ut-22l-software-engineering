package isp.lab2.Exercise6WordGuess;

import java.util.Scanner;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     *
     * @param c
     * @param word
     * @return
     */
    public static int[] getOccurrencePositions(char c, char[] word) {
        return null;
    }

    public static void main(String[] args) {
        char[] word = null; // replace with a word from a dictionary
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);

        int tries = 0;
        while (tries < 10 && !solved) {
            tries++;
            System.out.println("Enter a letter: ");
            String letter = scanner.nextLine();
            int[] occurrences = getOccurrencePositions(letter.charAt(0), word);
            // todo: continue the implementation
        }
    }

}
