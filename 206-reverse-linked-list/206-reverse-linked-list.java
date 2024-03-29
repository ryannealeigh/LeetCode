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
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode curr = head;
        
        while (head != null) {
            curr = head.next;
            head.next = next;
            next = head;
            head = curr;
        }
        
        return next;
    }
}