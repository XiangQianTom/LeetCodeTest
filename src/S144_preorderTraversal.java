import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S144_preorderTraversal {
    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     * https://leetcode.cn/problems/binary-tree-preorder-traversal/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{1, null, 2, 3})));
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{1})));
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{1, 2})));
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{1, null, 2})));
        System.out.println(solution.preorderTraversal1(TreeNode.buildTree(new Integer[]{1, null, 2, 3, 6, 7, 8, 9})));
    }

    static class Solution {

        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> queue = new Stack<>();
            TreeNode node = root;
            while (!queue.isEmpty() || null != node) {
                while (null != node) {
                    list.add(node.val);
                    queue.push(node);
                    node = node.left;
                }
                node = queue.pop();
                node = node.right;
            }
            return list;
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preorderTraversal(root, list);
            return list;
        }

        private void preorderTraversal(TreeNode root, List<Integer> list) {
            if (null == root) {
                return;
            }
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
