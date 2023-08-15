import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S112_HasPathSum {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     * 解释：等于目标和的根节点到叶节点路径如上图所示。
     * 示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     * 解释：树中存在两条根节点到叶子节点的路径：
     * (1 --> 2): 和为 3
     * (1 --> 3): 和为 4
     * 不存在 sum = 5 的根节点到叶子节点的路径。
     * 示例 3：
     * 输入：root = [], targetSum = 0
     * 输出：false
     * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum2(TreeNode.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 22}), 22));
        System.out.println(solution.hasPathSum2(TreeNode.buildTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(solution.hasPathSum2(TreeNode.buildTree(new Integer[]{}), 0));
        System.out.println(solution.hasPathSum2(TreeNode.buildTree(new Integer[]{1, 2}), 2));
    }

    static class Solution {
        public boolean hasPathSum2(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> sum = new LinkedList<>();
            queue.offer(root);
            sum.offer(root.val);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                Integer temp = sum.poll();
                if (null == node.left && null == node.right) {
                    if (targetSum == temp) {
                        return true;
                    }
                    continue;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                    sum.offer(node.left.val + temp);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                    sum.offer(node.right.val + temp);
                }
            }
            return false;
        }

        public boolean hasPathSum1(TreeNode root, int targetSum) {
            if (null == root) {
                return false;
            }
            if (null == root.left && null == root.right) {
                return root.val == targetSum;
            }
            return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            return hasPathSum(root, targetSum, 0);
        }

        private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
            if (null == root) {
                return false;
            }
            sum += root.val;
            if (null == root.left && null == root.right) {
                return targetSum == sum;
            }
            return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
        }
    }
}
