/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // HashSet<ListNode> visited = new HashSet<>();
        // ListNode current = head;
        // while(current != null){
        //     if(visited.contains(current)){
        //         return true;
        //     }
        //     visited.add(current);
        //     current = current.next;
        // }
        // return false;
        
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast=fast.next.next;
            slow = slow.next;
        }
        return false;
        
    }
}