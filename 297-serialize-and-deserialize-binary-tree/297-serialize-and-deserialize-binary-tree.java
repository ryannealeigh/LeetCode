/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder tree = new StringBuilder();
        if (root == null) {
            return tree.toString();
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.val == Integer.MAX_VALUE) {
                tree.append("null#");
                continue;
            } else {
                tree.append(node.val + "#");
            }
            
            if (node.left == null) {
                queue.add(new TreeNode(Integer.MAX_VALUE));
            } else {
                queue.add(node.left);
            }
            if (node.right == null) {
                queue.add(new TreeNode(Integer.MAX_VALUE));
            } else {
                queue.add(node.right);
            }
            
        }
        return tree.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data.length() == 0) return null;

        String[] split = data.split("#");
        
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(split[i++]));
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[i].equals("null")) {
                int val = Integer.parseInt(split[i]);
                node.left = new TreeNode(val);
            }
            i++;
            if (node.left != null) queue.add(node.left);
            
            if (!split[i].equals("null")) {
                int val = Integer.parseInt(split[i]);
                node.right = new TreeNode(val);
            }
            i++;
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));