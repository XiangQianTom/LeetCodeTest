import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S104_maxDepth {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     * 示例 2：
     * 输入：root = [1,null,2]
     * 输出：2
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth2(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.maxDepth2(TreeNode.buildTree(new Integer[]{1, null, 2})));
        System.out.println(solution.maxDepth2(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.maxDepth2(TreeNode.buildTree(new Integer[]{0})));
    }

    static class Solution {

        public int maxDepth2(TreeNode root) {
            if (null == root) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                sum++;
            }
            return sum;
        }

        public int maxDepth1(TreeNode root) {
            return null == root ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
        }

        public int maxDepth(TreeNode root) {
            return maxDepth(root, 0);
        }

        private int maxDepth(TreeNode root, int deep) {
            if (null == root) {
                return deep;
            }
            deep++;
            return Math.max(maxDepth(root.left, deep),
                    maxDepth(root.right, deep));
        }
    }
}
