import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S257_binaryTreePaths {
    /**
     * 257. 二叉树的所有路径
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     * 示例 2：
     * 输入：root = [1]
     * 输出：["1"]
     * https://leetcode.cn/problems/binary-tree-paths/description/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths1(TreeNode.buildTree(new Integer[]{1, 2, 3, null, 5})));
        System.out.println(solution.binaryTreePaths1(TreeNode.buildTree(new Integer[]{1})));
        System.out.println(solution.binaryTreePaths1(TreeNode.buildTree(new Integer[]{1, 2})));
    }

    static class Solution {
        public List<String> binaryTreePaths1(TreeNode root) {
            List<String> list = new ArrayList<>();
            if (null == root) {
                return list;
            }
            LinkedList<Object> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(String.valueOf(root.val));
            while (!queue.isEmpty()) {
                TreeNode node = (TreeNode) queue.poll();
                String path = (String) queue.poll();
                if (null == node.left && null == node.right) {
                    list.add(path);
                    continue;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                    queue.offer(path + "->" + node.left.val);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                    queue.offer(path + "->" + node.right.val);
                }
            }
            return list;
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            binaryTreePaths(root, list, "");
            return list;
        }

        private void binaryTreePaths(TreeNode root, List<String> list, String parent) {
            if (null == root) {
                return;
            }
            String current = parent + root.val;
            if (null == root.left && null == root.right) {
                list.add(current);
                return;
            }
            current = current + "->";
            binaryTreePaths(root.left, list, current);
            binaryTreePaths(root.right, list, current);
        }
    }
}
