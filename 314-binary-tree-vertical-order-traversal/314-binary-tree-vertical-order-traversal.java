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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int minCol = 0;
        int maxCol = 0;
        if (root == null) {
            return List.of();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        // bfs to do level by level
        // put pair into queue of Node and column
        // add node vals to appropriate list in map
        // add all lists from map to result list in correct order
        
        ArrayDeque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            
            for (int i = 0; i < n; i++) {
                Pair curr = queue.poll();
                TreeNode node = (TreeNode) curr.getKey();
                int col = (int) curr.getValue();
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);
                
                if (node.left != null) {
                    queue.add(new Pair(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, col + 1));
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
}