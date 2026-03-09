// File: PalindromeCheckerApp.java
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("========== Palindrome Checker App: UC13 Performance Comparison ==========");

        String testStr = "racecar";  // Sample palindrome

        // Initialize strategies
        PalindromeStrategy stackStrategy = new StackPalindromeStrategy();
        PalindromeStrategy dequeStrategy = new DequePalindromeStrategy();
        PalindromeStrategy stringReverseStrategy = new StringReversePalindromeStrategy();

        // Compare performance
        measurePerformance("Stack Strategy", stackStrategy, testStr);
        measurePerformance("Deque Strategy", dequeStrategy, testStr);
        measurePerformance("String Reverse Strategy", stringReverseStrategy, testStr);
    }

    private static void measurePerformance(String name, PalindromeStrategy strategy, String input) {
        long start = System.nanoTime();
        boolean result = strategy.isPalindrome(input);
        long end = System.nanoTime();
        System.out.println(name + ": " + (result ? "Palindrome" : "Not Palindrome") +
                " | Execution time: " + (end - start) + " ns");
    }
}

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based implementation
class StackPalindromeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
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
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// String Reverse-based implementation
class StringReversePalindromeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) reversed += str.charAt(i);
        return str.equals(reversed);
    }
}