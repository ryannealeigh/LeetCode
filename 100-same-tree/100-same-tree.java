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
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return true;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        queue.add(p);
        queue.add(q);
        
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (!check(p.left, q.left)) return false;
            if (p.left != null) queue.add(p.left);
            if (q.left != null) queue.add(q.left);
            if (!check(p.right, q.right)) return false;
            if (p.right != null) queue.add(p.right);
            if (q.right != null) queue.add(q.right);
        }
        
        return true;
    }
}