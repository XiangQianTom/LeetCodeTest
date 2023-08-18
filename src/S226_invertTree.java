import utils.TreeNode;

import java.util.LinkedList;

public class S226_invertTree {
    /**
     * 226. 翻转二叉树
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 示例 2：
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     * 示例 3：
     * 输入：root = []
     * 输出：[]
     * https://leetcode.cn/problems/invert-binary-tree/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print(TreeNode.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
        solution.print(TreeNode.buildTree(new Integer[]{2, 1, 3}));
        solution.print(TreeNode.buildTree(new Integer[]{}));
    }

    static class Solution {

        public void print(TreeNode root) {
            if (null == root) {
                return;
            }
            invertTree1(root).printTree();
        }

        public TreeNode invertTree1(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null == node) {
                    continue;
                }
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return root;
        }

        public TreeNode invertTree(TreeNode root) {
            if (null == root) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
