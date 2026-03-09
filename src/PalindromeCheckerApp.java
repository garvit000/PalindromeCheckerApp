// File: PalindromeCheckerApp.java
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "1.0";

    public static void main(String[] args) {
        // ===== UC1: Welcome Message =====
        System.out.println("=======================================");
        System.out.println("Welcome to " + APP_NAME + "!");
        System.out.println("Version: " + VERSION);
        System.out.println("This application checks if a string is a palindrome.");
        System.out.println("=======================================");
        System.out.println("You can now proceed to enter strings for palindrome checking in the next use case.\n");

        // ===== UC2 to UC6 (existing implementations) =====
        // ... same as before

        // ===== UC7: Deque-Based Optimized Palindrome Check =====
        String uc7Str = "rotor";  // example string
        Deque<Character> deque = new ArrayDeque<>();

        // Insert all characters into deque
        for (char c : uc7Str.toCharArray()) {
            deque.addLast(c);
        }

        boolean isUC7Palindrome = true;
        while (deque.size() > 1) {  // check until deque is empty or one element left
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isUC7Palindrome = false;
                break;
            }
        }

        System.out.println("UC7 Result: \"" + uc7Str + "\" is "
                + (isUC7Palindrome ? "" : "NOT ")
                + "a palindrome (deque optimized check).");
    }
}