// File: PalindromeCheckerApp.java
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
    }
}