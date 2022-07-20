/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    Node result;
    public Node lowestCommonAncestor(Node p, Node q) {
        // find root of tree
        Node root = p;
        while (root.parent != null) {
            root = root.parent;
        }
        
        search(root, p, q);
        
        return result;
    }
    
    private boolean search(Node root, Node p, Node q) {
        if (root == null) {
            return false;
        }
        
        boolean rt = (root == p || root == q);
        
        boolean left = search(root.left, p, q);
        boolean right = search(root.right, p, q);
        
        if ((rt && left) || (rt && right) || left && right) {
            result = root;
        }
        
        return rt || left || right;
    }
}