package isp.lab2.Exercise4StringSearch;

import java.util.*;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param input
     * @param substr what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substr) {
        String[] splitInput = input.split(",");
        List<String> result = new ArrayList<>();

        for(String str: splitInput) {
            if(str.contains(substr)) {
                result.add(str);
            }
        }

        return result.toArray(new String[0]);
    }

    public static String readFromConsole(String suffix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + suffix + ": ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = readFromConsole("words");
        String substring = readFromConsole("substring");
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
