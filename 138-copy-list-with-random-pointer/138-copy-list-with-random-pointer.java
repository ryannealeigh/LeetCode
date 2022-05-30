/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node curr = dummy;
        
        while (head != null) {
            map.putIfAbsent(head, new Node(head.val));
            curr.next = map.get(head);
            curr = curr.next;
            if (head.random != null) {
                map.putIfAbsent(head.random, new Node(head.random.val));
                curr.random = map.get(head.random);
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}