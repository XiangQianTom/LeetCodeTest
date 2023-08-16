import utils.TreeNode;

public class S110_isBalanced {
    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     * 示例 3：
     * 输入：root = []
     * 输出：true
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.isBalanced(TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println(solution.isBalanced(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.isBalanced(TreeNode.buildTree(new Integer[]{1})));
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        private int height(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
                return Math.max(left, right) + 1;
            }
            return -1;
        }
    }
}
