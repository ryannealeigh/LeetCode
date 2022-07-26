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
    public ListNode swapPairs(ListNode head) {
        // set Node ptr curr equal to head
        // swap curr with curr.next, also keeping track of curr.next.next
        // set curr to curr.next.next
        // repeat
        
        ListNode curr = head;
        boolean first = true;
        ListNode prev = null;
        
        while (curr != null && curr.next != null) {
            // swap curr with next;
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr;
            if (first) {
                head = temp;
                first = false;
            }
            if (prev != null) {
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }
        
        return head;
    }
}