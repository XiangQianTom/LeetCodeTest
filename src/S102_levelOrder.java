import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S102_levelOrder {
    /**
     * 102. 二叉树的层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * 输入：root = []
     * 输出：[]
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.levelOrder(TreeNode.buildTree(new Integer[]{1})));
        System.out.println(solution.levelOrder(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.levelOrder(TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null, 11, 12, 13})));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            levelOrder(root, 1, list);
            return list;
        }

        private void levelOrder(TreeNode root, int deep, List<List<Integer>> list) {
            if (null == root) {
                return;
            }
            if (list.size() < deep) {
                list.add(new ArrayList<>());
            }
            list.get(deep - 1).add(root.val);
            levelOrder(root.left, deep + 1, list);
            levelOrder(root.right, deep + 1, list);
        }
    }
}
