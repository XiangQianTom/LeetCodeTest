import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S94_InorderTraversal {
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(TreeNode.buildTree(new Integer[]{1, null, 2, 3})));
        System.out.println(solution.inorderTraversal(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.inorderTraversal(TreeNode.buildTree(new Integer[]{1})));
    }


    static class Solution {

        private List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }

        public List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            return inorderTraversal1(root, list);
        }

        private List<Integer> inorderTraversal1(TreeNode root, List<Integer> list) {
            if (root == null) {
                return list;
            }
            inorderTraversal1(root.left, list);
            list.add(root.val);
            inorderTraversal1(root.right, list);
            return list;
        }
    }
}
