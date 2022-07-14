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
    int sum = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        // pass along previous and current val to next node down the tree
        // this is going to be grandparent and parent

        search(root, 1, 1);
        return sum;
    }
    
    private void search(TreeNode root, int grandparent, int parent) {
        if (root == null) {
            return;
        }
        
        if (grandparent % 2 == 0) {
            sum += root.val;
        }
        
        search(root.left, parent, root.val);
        search(root.right, parent, root.val);
    }
}