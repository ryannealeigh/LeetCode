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
    int kth;
    
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 0);
        return kth;
    }
    
    private int dfs(TreeNode root, int k, int count) {
        if (root == null) {
            return count;
        }
        
        count = dfs(root.left, k, count);
        count++;
        if (count == k) {
            kth = root.val;
        }
        return dfs(root.right, k, count);
    }
}