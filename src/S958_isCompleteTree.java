import utils.TreeNode;

import java.util.LinkedList;

public class S958_isCompleteTree {
    /**
     * 958. 二叉树的完全性检验
     * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
     * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
     * 示例 1：
     * 输入：root = [1,2,3,4,5,6]
     * 输出：true
     * 解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
     * 示例 2：
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：false
     * 解释：值为 7 的节点不满足条件「节点尽可能靠左」。
     * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
     */
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isCompleteTree(TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, 6})));//true
        System.out.println(solution.isCompleteTree(TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7})));//false
        System.out.println(solution.isCompleteTree(TreeNode.buildTree(new Integer[]{1, 2, 3, 5, 6, 7, null})));//true
        System.out.println(solution.isCompleteTree(TreeNode.buildTree(new Integer[]{1, 2, 3, 5, null, 7, 8})));//false
    }

    static class Solution1 {
        public boolean isCompleteTree(TreeNode root) {
            if (null == root) {
                return true;
            }
            LinkedList<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.offer(root);
            boolean isNull = false;
            while (!treeNodes.isEmpty()) {
                TreeNode node = treeNodes.poll();
                if (null == node) {
                    isNull = true;
                    continue;
                }
                if (isNull) {
                    return false;
                }
                treeNodes.offer(node.left);
                treeNodes.offer(node.right);
            }
            return true;
        }
    }
}
