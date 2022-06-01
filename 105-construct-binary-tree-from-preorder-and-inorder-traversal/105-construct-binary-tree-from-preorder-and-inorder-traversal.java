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
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
                
        return makeTree(preorder, map, 0, preorder.length - 1);
    }
    
    private TreeNode makeTree(int[] preorder, HashMap<Integer, Integer> map, int left, int right) {
        int val = preorder[i++];
        TreeNode node = new TreeNode(val);
        int pivot = map.get(val);
        
        if (pivot - left > 0) {
            node.left = makeTree(preorder, map, left, pivot - 1);
        }
        
        if (right - pivot > 0) {
            node.right = makeTree(preorder, map, pivot + 1, right);
        }
        
        return node;
    }
}