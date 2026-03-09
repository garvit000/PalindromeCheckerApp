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

        // ===== UC9: Recursive Palindrome Checker =====
        String uc9Str = "level"; // example string
        boolean isUC9Palindrome = isPalindromeRecursive(uc9Str, 0, uc9Str.length() - 1);

        System.out.println("UC9 Result: \"" + uc9Str + "\" is "
                + (isUC9Palindrome ? "" : "NOT ")
                + "a palindrome (recursive check).");
    }

    // Recursive palindrome check
    static boolean isPalindromeRecursive(String str, int left, int right) {
        // Base case: reached middle or crossed indices
        if (left >= right) return true;

        // Mismatch found
        if (str.charAt(left) != str.charAt(right)) return false;

        // Recur for inner substring
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}