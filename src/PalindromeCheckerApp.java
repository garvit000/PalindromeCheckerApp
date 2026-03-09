// File: PalindromeCheckerApp.java
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {

    // Application details
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

        // ===== UC2: Hardcoded Palindrome Check =====
        String str = "madam";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("UC2 Result: \"" + str + "\" is " + (str.equals(reversed) ? "" : "NOT ") + "a palindrome.");

        // ===== UC3: Palindrome Check Using String Reverse with Loop =====
        String strToCheck = "racecar";
        String reverseStr = "";
        for (int i = strToCheck.length() - 1; i >= 0; i--) {
            reverseStr += strToCheck.charAt(i);
        }
        System.out.println("UC3 Result: \"" + strToCheck + "\" is " + (strToCheck.equals(reverseStr) ? "" : "NOT ") + "a palindrome.");

        // ===== UC4: Character Array Based Palindrome Check =====
        String uc4Str = "level";
        char[] charArray = uc4Str.toCharArray();
        boolean isPalindrome = true;
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("UC4 Result: \"" + uc4Str + "\" is " + (isPalindrome ? "" : "NOT ") + "a palindrome (char array check).");

        // ===== UC5: Stack-Based Palindrome Check =====
        String uc5Str = "deified";
        Stack<Character> stack = new Stack<>();
        for (char c : uc5Str.toCharArray()) {
            stack.push(c);
        }
        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed += stack.pop();
        }
        System.out.println("UC5 Result: \"" + uc5Str + "\" is " + (uc5Str.equals(stackReversed) ? "" : "NOT ") + "a palindrome (stack check).");

        // ===== UC6: Queue + Stack Based Palindrome Check =====
        String uc6Str = "noon";  // example string
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> uc6Stack = new Stack<>();

        // Enqueue and push all characters
        for (char c : uc6Str.toCharArray()) {
            queue.add(c);    // FIFO
            uc6Stack.push(c); // LIFO
        }

        boolean isUC6Palindrome = true;
        while (!queue.isEmpty() && !uc6Stack.isEmpty()) {
            if (!queue.remove().equals(uc6Stack.pop())) {
                isUC6Palindrome = false;
                break;
            }
        }

        System.out.println("UC6 Result: \"" + uc6Str + "\" is " + (isUC6Palindrome ? "" : "NOT ") + "a palindrome (queue + stack check).");
    }
}