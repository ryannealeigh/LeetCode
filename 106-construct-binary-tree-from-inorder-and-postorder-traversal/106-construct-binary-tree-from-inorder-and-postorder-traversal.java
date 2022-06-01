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
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return makeTree(postorder, map, 0, i);
    }
    
    private TreeNode makeTree(int[] postorder, HashMap<Integer, Integer> map, int left, int right) {
        int val = postorder[i--];
        TreeNode node = new TreeNode(val);
        int pivot = map.get(val);
                
        if (right - pivot > 0) {
            node.right = makeTree(postorder, map, pivot + 1, right);
        }
        
        if (pivot - left > 0) {
            node.left = makeTree(postorder, map, left, pivot - 1);
        }

        
        return node;
    }
}