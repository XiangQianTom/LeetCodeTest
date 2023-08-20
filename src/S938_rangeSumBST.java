import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S938_rangeSumBST {
    /**
     * 938. 二叉搜索树的范围和
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     * 示例 1：
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     * 示例 2：
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * 输出：23
     * https://leetcode.cn/problems/range-sum-of-bst/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(TreeNode.buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15));
        System.out.println(solution.rangeSumBST(TreeNode.buildTree(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 6, 10));
        System.out.println(solution.rangeSumBST(TreeNode.buildTree(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 1, 18));
    }

    static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            int sum = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null == node) {
                    continue;
                }
                if (node.val > high) {
                    queue.offer(node.left);
                } else if (node.val < low) {
                    queue.offer(node.right);
                } else {
                    sum += node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            return sum;
        }

        public int rangeSumBST2(TreeNode root, int low, int high) {
            if (null == root) {
                return 0;
            }
            if (root.val > high) {
                return rangeSumBST2(root.left, low, high);
            }
            if (root.val < low) {
                return rangeSumBST2(root.right, low, high);
            }
            return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
        }

        int sum = 0;

        public int rangeSumBST1(TreeNode root, int low, int high) {
            if (null == root) {
                return 0;
            }
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            rangeSumBST1(root.left, low, high);
            rangeSumBST1(root.right, low, high);
            return sum;
        }
    }
}
