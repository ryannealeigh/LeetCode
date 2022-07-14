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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = dfs(nums, 0, nums.length - 1);
        
        return root;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right || right < left) {
            return null;
        }
        
        int maxIndex = left;
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        return new TreeNode(max, dfs(nums, left, maxIndex - 1), dfs(nums, maxIndex + 1, right));
    }
}
