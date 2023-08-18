import utils.TreeNode;

public class S111_minDepth {
    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.minDepth(TreeNode.buildTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
        System.out.println(solution.minDepth(TreeNode.buildTree(new Integer[]{1, 2})));
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            } else if (root.right == null) {
                return minDepth(root.left) + 1;
            } else {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            }
        }

        public int minDepth2(TreeNode root) {
            if (null == root) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int minDeep = Integer.MAX_VALUE;
            if (root.left != null) {
                minDeep = Math.min(minDepth2(root.left), minDeep);
            }
            if (root.right != null) {
                minDeep = Math.min(minDepth2(root.right), minDeep);
            }
            return minDeep + 1;
        }

        public int minDepth1(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int left = minDepth1(root.left);
            int right = minDepth1(root.right);
            if (left == 0 || right == 0) {
                return left + right + 1;
            }
            return Math.min(left, right) + 1;
        }
    }
}
