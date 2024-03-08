package isp.lab2.Exercise6WordGuess;

import java.util.*;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     *
     * @param c
     * @param word
     * @return
     */
    public static int[] getOccurrencePositions(char c, char[] word) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < word.length; i++) {
            char letter = word[i];
            if(letter == c) result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

        String word_as_str = "EARLY"; // today's Wordle solution
        char[] word = word_as_str.toCharArray();
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);

        int tries = 0;
        int correct_letters = 0;
        while (tries < 10 && !solved) {
            tries++;
            System.out.print("Enter a letter: ");
            String letter = scanner.nextLine().toUpperCase();
            int[] occurrences = getOccurrencePositions(letter.charAt(0), word);


            if(occurrences.length == 0) {
                System.out.println("Word doesn't contain the letter " + letter);
            }
            else {
                System.out.print("The letter " + letter + " appears at index" + (occurrences.length > 1 ? "es:" : ":"));
                for(Integer occurrence: occurrences) System.out.print(" " + occurrence);
                System.out.println();

                correct_letters += occurrences.length;
                if(correct_letters == word.length) solved = true;
            }

        }

        System.out.println((solved ? "You've guessed the word " : "You've reached " +
                "the maximum amount of tries. The word was ") + word_as_str);
    }

}
