/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null) return false;
        if (subroot == null) return true;
        if (root.val == subroot.val && sameTree(root, subroot)) return true;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
    
    private boolean sameTree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) return true;
        if (root == null || subroot == null || root.val != subroot.val) return false;
        
        return sameTree(root.left, subroot.left) && sameTree(root.right, subroot.right);
    }
}