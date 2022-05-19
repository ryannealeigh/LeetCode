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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create new result list node
        // add numbers at current nodes
        // store sum % 10 at current node in result list
        // carry over remainder sum / 10 to next addition operation
        ListNode result = new ListNode();
        ListNode curr = result;
        int remainder = 0, sum = 0;
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + remainder;
            curr.val = sum % 10;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            remainder = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + remainder;
            curr.val = sum % 10;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            remainder = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + remainder;
            curr.val = sum % 10;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            remainder = sum / 10;
            l2 = l2.next;
        }

        //add final remainder if not 0
        if (remainder == 0) {
            prev.next = null;
        } else {
            curr.val = remainder;
        }

        return result;
    }
}
