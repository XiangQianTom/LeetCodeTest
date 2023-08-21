import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S199_rightSideView {
    /**
     * 199. 二叉树的右视图
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 示例 1:
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     * 输入: []
     * 输出: []
     * https://leetcode-cn.com/problems/binary-tree-right-side-view/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rightSideView(TreeNode.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4})));
        System.out.println(solution.rightSideView(TreeNode.buildTree(new Integer[]{1, null, 3})));
        System.out.println(solution.rightSideView(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.rightSideView(TreeNode.buildTree(new Integer[]{1, 2, 3, 4})));
    }

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            rightSideView(root, 1, list);
            return list;
        }

        private void rightSideView(TreeNode root, int deep, List<Integer> list) {
            if (null == root) {
                return;
            }
            if (list.size() < deep) {
                list.add(root.val);
            }
            rightSideView(root.right, deep + 1, list);
            rightSideView(root.left, deep + 1, list);
        }
    }
}
