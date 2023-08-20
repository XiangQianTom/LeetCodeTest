import utils.TreeNode;

public class S530_getMinimumDifference {
    /**
     * 530. 二叉搜索树的最小绝对差
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * 示例 1：
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     * 示例 2：
     * 输入：root = [1,0,48,null,null,12,49]
     * 输出：1
     * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(TreeNode.buildTree(new Integer[]{4, 2, 6, 1, 3})));
        System.out.println(solution.getMinimumDifference(TreeNode.buildTree(new Integer[]{1, 0, 48, null, null, 12, 49})));
        System.out.println(solution.getMinimumDifference(TreeNode.buildTree(new Integer[]{1, null, 3, null, 9})));
    }

    static class Solution {
        int current;
        int min;

        public int getMinimumDifference(TreeNode root) {
            current = -1;
            min = Integer.MAX_VALUE;
            dfs(root);
            return min;
        }

        private void dfs(TreeNode root) {
            if (null == root) {
                return;
            }
            dfs(root.left);
            if (current == -1) {
                current = root.val;
            } else {
                min = Math.min(min, root.val - current);
                current = root.val;
            }
            dfs(root.right);
        }
    }
}
