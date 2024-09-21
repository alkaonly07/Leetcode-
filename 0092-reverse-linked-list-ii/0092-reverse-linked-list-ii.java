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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
    if (head == null || left == right) {
            return head;  // No need to reverse if head is null or left == right
        }
        
        // Step 1: Move to the node before `left` position
        ListNode dummy = new ListNode(0); // Use a dummy node to simplify edge cases
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 1; i < left; i++) {
            prev = prev.next;  // Move `prev` to the node before the `left` node
        }
        
        // Step 2: Reverse the sublist between `left` and `right`
        ListNode start = prev.next;   // `start` is the first node of the sublist to reverse
        ListNode then = start.next;   // `then` is the node that will be reversed
        
        // Perform the reversal of the sublist
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;   // Move `then` node after the `start` node
            then.next = prev.next;    // Move `then` node to the front of the sublist
            prev.next = then;         // Update the `prev.next` to point to the `then` node
            then = start.next;        // Move `then` to the next node to reverse
        }
        
        return dummy.next;
    }
}