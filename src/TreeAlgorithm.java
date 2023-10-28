public class TreeAlgorithm {

    /**
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
     * 124. 二叉树中的最大路径和
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // 本质上是后续遍历，算出左右节点的值，再加上root看是否更大
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }

    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (pre != null && root.val <= pre.val)
            return false;

        pre = root;

        boolean right = isValidBST(root.right);
        return left && right;
    }

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
}
