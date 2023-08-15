import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class S101_IsSymmetric {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * 提示：
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(solution.isSymmetric(TreeNode.buildTree(new Integer[]{1, 2, 2, null, 3, null, 3})));

        System.out.println(solution.isSymmetric1(TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(solution.isSymmetric1(TreeNode.buildTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
        System.out.println(solution.isSymmetric1(TreeNode.buildTree(new Integer[]{9, -42, -42, null, 76, 76, null, null, 13, null, 13})));
    }

    static class Solution {
        public boolean isSymmetric1(TreeNode root) {
            if (null == root) {
                return true;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root.left);
            deque.offer(root.right);
            while (!deque.isEmpty()) {
                TreeNode left = deque.poll();
                TreeNode right = deque.poll();
                if (null == left && null == right) {
                    continue;
                }
                if (null == left || null == right) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                deque.offer(left.left);
                deque.offer(right.right);
                deque.offer(left.right);
                deque.offer(right.left);
            }
            return true;
        }

        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (null == left && null == right) {
                return true;
            }
            if (null == left || null == right) {
                return false;
            }
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
