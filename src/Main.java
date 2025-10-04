import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int balance = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String original = Integer.toString(num);
        String result = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            result += original.charAt(i);
        }
        return result;
        }


    // 3. encryptThis
    public static String encryptWord(String word) {
        int firstNumber = (int) word.charAt(0);
        if (word.length() == 1) {
            return String.valueOf(firstNumber);
        }
        if (word.length() == 2) {
            // Concatenate without summing integers
            return firstNumber + "" + word.charAt(1);
        }
        return firstNumber
                + ""
                + word.charAt(word.length() - 1)  // last letter
                + word.substring(2, word.length() - 1)  // middle letters unchanged
                + word.charAt(1);  // second letter
    }

    public static String encryptThis(String input) {
        String[] words = input.split(" ");
        StringBuilder encrypted = new StringBuilder();

        for (String word : words) {
            encrypted.append(encryptWord(word)).append(" ");
        }

        return encrypted.toString().trim();
    }


    // 4. decipherThis
    public static void main(String[] args) {
        // Test cases from the examples
        System.out.println(decipherThis("72olle 103doo 100ya")); // "Hello good day"
        System.out.println(decipherThis("82yade 115te 103o"));  // "Ready set go"
    }

    public static String decipherThis(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder deciphered = new StringBuilder();

        for (String word : words) {
            deciphered.append(decipherWord(word)).append(" ");
        }

        return deciphered.toString().trim();
    }

    private static String decipherWord(String word) {
        int i = 0;
        while (i < word.length() && Character.isDigit(word.charAt(i))) {
            i++;
        }

        String charCodeStr = word.substring(0, i);
        char firstChar = (char) Integer.parseInt(charCodeStr);
        String rest = word.substring(i);

        if (rest.length() > 1) {
            char secondChar = rest.charAt(0);
            char lastChar = rest.charAt(rest.length() - 1);
            String middle = "";
            if (rest.length() > 2) {
                middle = rest.substring(1, rest.length() - 1);
            }
            rest = lastChar + middle + secondChar;
        }
        return firstChar + rest;
    }
}

