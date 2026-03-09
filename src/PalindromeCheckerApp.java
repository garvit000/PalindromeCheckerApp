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

        // ===== UC8: Linked List Based Palindrome Checker =====
        String uc8Str = "racecar"; // example string

        Node head = buildLinkedList(uc8Str);
        boolean isUC8Palindrome = checkLinkedListPalindrome(head);

        System.out.println("UC8 Result: \"" + uc8Str + "\" is "
                + (isUC8Palindrome ? "" : "NOT ")
                + "a palindrome (linked list check).");
    }

    // Node class for singly linked list
    static class Node {
        char val;
        Node next;
        Node(char val) { this.val = val; this.next = null; }
    }

    // Build linked list from string
    static Node buildLinkedList(String str) {
        if (str == null || str.isEmpty()) return null;
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    // Check palindrome using fast/slow pointer and reverse second half
    static boolean checkLinkedListPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle (slow = mid, fast = end)
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalfStart = reverseList(slow.next);

        // Compare halves
        Node firstHalf = head;
        Node secondHalf = secondHalfStart;
        boolean palindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: restore list
        slow.next = reverseList(secondHalfStart);

        return palindrome;
    }

    // Reverse linked list
    static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}