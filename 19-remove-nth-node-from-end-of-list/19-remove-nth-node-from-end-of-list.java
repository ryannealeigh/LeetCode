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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        int nodeToRemove = (count - n) + 1;
        if (nodeToRemove == 1) {
            return head.next;
        }

        count = 0;
        curr = head;
        while (curr != null) {
            count++;
            if (count + 1 == nodeToRemove) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }

        return head;
    }
}