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
    
    class Pair {
        int sum;
        int count;
        
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    int result = 0;
    
    public int averageOfSubtree(TreeNode root) {
        search(root);
        
        return result;
    }
    
    private Pair search(TreeNode node) {
        // if (node.left == null && node.right == null) {
        //     result++;
        //     return new Pair(node.val, 1);
        // }
                
        int sum = node.val;
        int count = 1;
        
        if (node.left != null) {
            Pair left = search(node.left);
            sum += left.sum;
            count += left.count;
        }
        
        if (node.right != null) {
            Pair right = search(node.right);
            sum += right.sum;
            count += right.count;
        }
                
        if (sum / count == node.val) {
            result++;
        }
        
        return new Pair(sum, count);
    }
}