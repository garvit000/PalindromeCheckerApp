// File: PalindromeCheckerApp.java
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

        // ===== UC11: Object-Oriented Palindrome Service =====
        PalindromeChecker checker = new PalindromeChecker();

        String testStr1 = "radar";
        String testStr2 = "hello";

        System.out.println("UC11 Result: \"" + testStr1 + "\" is "
                + (checker.checkPalindrome(testStr1) ? "" : "NOT ")
                + "a palindrome.");
        System.out.println("UC11 Result: \"" + testStr2 + "\" is "
                + (checker.checkPalindrome(testStr2) ? "" : "NOT ")
                + "a palindrome.");
    }
}

// PalindromeChecker class encapsulates the logic
class PalindromeChecker {

    // Method to check palindrome using simple two-pointer technique
    public boolean checkPalindrome(String str) {
        if (str == null) return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}