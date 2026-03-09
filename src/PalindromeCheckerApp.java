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

        // ===== UC10: Case-Insensitive & Space-Ignored Palindrome =====
        String uc10Str = "A man a plan a canal Panama"; // example
        String normalized = uc10Str.replaceAll("\\s+", "").toLowerCase(); // remove spaces & lowercase

        boolean isUC10Palindrome = isPalindromeRecursive(normalized, 0, normalized.length() - 1);

        System.out.println("UC10 Result: \"" + uc10Str + "\" is "
                + (isUC10Palindrome ? "" : "NOT ")
                + "a palindrome (case-insensitive & space-ignored).");
    }

    // Reusable recursive palindrome check
    static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true;           // Base case
        if (str.charAt(left) != str.charAt(right)) return false; // mismatch
        return isPalindromeRecursive(str, left + 1, right - 1); // recur inward
    }
}