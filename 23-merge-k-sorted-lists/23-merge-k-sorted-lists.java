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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null) {
                heap.add(curr.next);
            }
        }
        
        return head.next;
    }
}