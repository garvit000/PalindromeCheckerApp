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

        // UC12: Strategy Pattern Example
        String testStr = "level";

        // Use Stack Strategy
        PalindromeStrategy stackStrategy = new StackPalindromeStrategy();
        PalindromeContext context = new PalindromeContext(stackStrategy);
        System.out.println("Stack Strategy: \"" + testStr + "\" is "
                + (context.check(testStr) ? "" : "NOT ") + "a palindrome.");

        // Switch to Deque Strategy
        PalindromeStrategy dequeStrategy = new DequePalindromeStrategy();
        context.setStrategy(dequeStrategy);
        System.out.println("Deque Strategy: \"" + testStr + "\" is "
                + (context.check(testStr) ? "" : "NOT ") + "a palindrome.");
    }
}

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based implementation
class StackPalindromeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based implementation
class DequePalindromeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.isPalindrome(str);
    }
}