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
        // cut the list in half and compare the nodes
        // find the halfway mark
        // reverse the first half
        // then compare the remainders
        
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (fast != null && fast.next != null) {
            i++;
            slow = slow.next;
            fast = fast.next.next;
        }
                
        if (fast != null) {
            slow = slow.next;
        }
        
        // reverse first i nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int j = 0; j < i; j++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // now prev has our head
        // compare nodes in prev list to nodes at slow
        
        for (int j = 0; j < i; j++) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        
        return true;
    }
}