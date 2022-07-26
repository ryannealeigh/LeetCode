/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {     
        if (root == null) return null;
        dfs(root, p, q);
        
        return lca;
    }
    
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        
        boolean self = root.val == p.val || root.val == q.val;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        
        if ((left && right) || (left && self) || (self && right)) {
            lca = root;
        }
        
        return self || left || right;
    }
}