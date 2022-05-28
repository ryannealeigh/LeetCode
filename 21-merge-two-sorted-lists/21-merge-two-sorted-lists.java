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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode i = list1.val <= list2.val ? list1 : list2;
        ListNode j = list1.val <= list2.val ? list2 : list1;
        ListNode head = i;

        ListNode temp;
        while (j != null) {
            while (i.next != null && i.next.val <= j.val) {
                i = i.next;
            }
            
            if (i.next == null && j != null) {
                i.next = j;
                return head;
            }
            
            temp = i.next;
            i.next = j;
            while (j.next != null && j.next.val <= temp.val) {
                j = j.next;
            }
            i = j;
            j = j.next;
            i.next = temp;
        }
        
        return head;
    }
}