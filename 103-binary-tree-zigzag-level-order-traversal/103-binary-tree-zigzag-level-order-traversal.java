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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        boolean forward = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (forward) {
                    TreeNode node = queue.poll();
                    row.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    row.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }
            forward = !forward;
            result.add(row);
        }

        return result;
    }
}
