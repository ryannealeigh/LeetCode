/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // do bfs, we have to first find target and keep list of parent nodes up until target

        parents = new ArrayList<>();
        if (root != target) {
            findTarget(root, target, new ArrayList<>());
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(target);

        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        int dist = -1;
        int parentPtr = parents.size() - 1;

        while (dist < k) {
            dist++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                if (dist == k) {
                    result.add(curr.val);
                    continue;
                }
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                }
                if (curr == target && parentPtr >= 0) {
                    queue.add(parents.get(parentPtr));
                } else if (parentPtr > 0 && curr == parents.get(parentPtr)) {
                    queue.add(parents.get(--parentPtr));
                }
            }
        }

        return result;
    }

    private void findTarget(TreeNode root, TreeNode target, List<TreeNode> currParents) {
        if (root == null) {
            return;
        }
        if (root == target) {
            parents = new ArrayList<>(currParents);
            return;
        }
        currParents.add(root);
        findTarget(root.left, target, currParents);
        findTarget(root.right, target, currParents);
        currParents.remove(currParents.size() - 1);
    }
}
