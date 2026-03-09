// File: PalindromeCheckerApp.java
import java.util.Stack;

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
        String str = "madam";  // hardcoded string
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            System.out.println("UC2 Result: The string \"" + str + "\" is a palindrome.");
        } else {
            System.out.println("UC2 Result: The string \"" + str + "\" is NOT a palindrome.");
        }

        // ===== UC3: Palindrome Check Using String Reverse with Loop =====
        String strToCheck = "racecar";  // example string
        String reverseStr = "";

        // reverse string manually
        for (int i = strToCheck.length() - 1; i >= 0; i--) {
            reverseStr += strToCheck.charAt(i); // concatenation
        }

        if (strToCheck.equals(reverseStr)) {
            System.out.println("UC3 Result: The string \"" + strToCheck + "\" is a palindrome.");
        } else {
            System.out.println("UC3 Result: The string \"" + strToCheck + "\" is NOT a palindrome.");
        }

        // ===== UC4: Character Array Based Palindrome Check =====
        String uc4Str = "level"; // example string for UC4
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

        if (isPalindrome) {
            System.out.println("UC4 Result: The string \"" + uc4Str + "\" is a palindrome (char array check).");
        } else {
            System.out.println("UC4 Result: The string \"" + uc4Str + "\" is NOT a palindrome (char array check).");
        }

        // ===== UC5: Stack-Based Palindrome Check =====
        String uc5Str = "deified"; // example string for UC5
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char c : uc5Str.toCharArray()) {
            stack.push(c);
        }

        // Pop characters and build reversed string
        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed += stack.pop();
        }

        if (uc5Str.equals(stackReversed)) {
            System.out.println("UC5 Result: The string \"" + uc5Str + "\" is a palindrome (stack check).");
        } else {
            System.out.println("UC5 Result: The string \"" + uc5Str + "\" is NOT a palindrome (stack check).");
        }
    }
}