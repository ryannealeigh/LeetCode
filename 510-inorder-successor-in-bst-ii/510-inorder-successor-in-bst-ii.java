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
    boolean found;
    Node result;
    
    public Node inorderSuccessor(Node node) {
        found = false;
        result = null;
        
        Node root = node;
        
        while (root.parent != null) {
            root = root.parent;
        }
        
        dfs(root, node);
        
        return result;
    }
    
    private void dfs(Node root, Node target) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, target);
        if (found) {
            result = root;
            found = false;
        }
        if (root == target) {
            found = true;
        }
        dfs(root.right, target);
    }
}