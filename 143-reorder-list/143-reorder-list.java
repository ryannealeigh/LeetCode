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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // move slow ahead one node in the odd case
        if (fast != null) {
            temp = slow;
            slow = slow.next;
        }
        // set end of head to null
        temp.next = null;
        
        // now slow is set to back half of list we want to 
        // reverse slow
        ListNode prev = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        ListNode curr = head;
        while (prev != null) {
            temp = curr.next;
            curr.next = prev;
            prev = prev.next;
            curr = curr.next;
            curr.next = temp;
            curr = curr.next;
        }
    }
}