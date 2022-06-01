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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).get(0) == 1;
    }
    
    private List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return List.of(1, 0);
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        
        boolean childrenBalanced = left.get(0) == 1 && right.get(0) == 1;
        boolean balanced = Math.abs(left.get(1) - right.get(1)) <= 1;
        
        List<Integer> result = new ArrayList<>();
        if (childrenBalanced && balanced) {
            result.add(1);
        } else {
            result.add(0);
        }
        
        result.add(1 + Math.max(left.get(1), right.get(1)));
        return result;
    }
}