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
        int totalNodes = 0;
        ListNode ptr = head;

        while (ptr != null) {
            totalNodes++;
            ptr = ptr.next;
        }

        int groups = totalNodes / k;
        int groupCount = 0;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = head;

        while (groupCount < groups) {
            ListNode last = tail.next;
            tail.next = reverseGroup(tail.next, k);
            tail = last;
            groupCount++;
        }

        return dummy.next;
    }

    private ListNode reverseGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode last = head;

        for (int i = 0; i < k; i++) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        last.next = head;

        return prev;
    }
}
