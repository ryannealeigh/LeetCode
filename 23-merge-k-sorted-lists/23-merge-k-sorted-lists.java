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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int interval = 1;
        
        while (interval < n) {
            for (int i = 0; i < n - interval; i += interval * 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < n ? lists[i + interval] : null;

                lists[i] = mergeLists(l1, l2);
            }
            interval *= 2;
        }
        if (n > 0) return lists[0];
        return null;
    }
    
    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        
        return dummy.next;
    }
}