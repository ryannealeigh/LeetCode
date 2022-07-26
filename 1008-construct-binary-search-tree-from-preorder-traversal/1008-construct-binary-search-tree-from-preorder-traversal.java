class Solution {
    int idx;
    int[] preorder;
    int n;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        this.preorder = preorder;
        n = preorder.length;

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int lower, int upper) {
        if (idx == n) return null;

        int val = preorder[idx];

        if (val < lower || val > upper) return null;

        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;
    }
}
