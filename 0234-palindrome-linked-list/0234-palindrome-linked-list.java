/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty or single-node list is always a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next; // moves one step
            fast = fast.next.next; // moves two steps
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalfStart = reverseList(slow);
        
        // Step 3: Compare the first and second halves
        ListNode firstHalfStart = head;
        ListNode secondHalfCopy = secondHalfStart; // To restore later if needed
        
        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                return false; // Not a palindrome
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        
        // Step 4: (Optional) Restore the original list if you want
        // reverseList(secondHalfCopy);
        
        return true; // List is a palindrome
    }

    // Helper function to reverse the linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    
}