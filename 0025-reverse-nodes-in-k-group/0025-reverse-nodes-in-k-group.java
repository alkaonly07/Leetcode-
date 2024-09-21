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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode start = head;
        while(true){
            ListNode kNode = kthNode(start , k);
            if(kNode == null){
                break;
            }
            ListNode newStart = kNode.next;
            reverse(start, kNode);
            start.next = newStart;
            prev.next = kNode;
            prev = start;
            start = newStart;
            
            
        }
        return dummy.next;
        
        
    }
    private ListNode kthNode(ListNode start, int k){
        while(start != null && k>1){
            start = start.next;
            k--;
        }
        return start;
    }
    private void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode current = start;
        ListNode next = null;
        while(prev != end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            
        }
    }
}