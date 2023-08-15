import utils.TreeNode;

public class S543_diameterOfBinaryTree {
    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     * 示例 1：
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     * 输入：root = [1,2]
     * 输出：1
     */
    public static void main(String[] args) {
        System.out.println(new Solution().diameterOfBinaryTree1(TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5})));
        System.out.println(new Solution().diameterOfBinaryTree1(TreeNode.buildTree(new Integer[]{1, 2})));
        System.out.println(new Solution().diameterOfBinaryTree1(TreeNode.buildTree(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2})));
    }

    static class Solution {
        int maxDeep;

        public int diameterOfBinaryTree1(TreeNode root) {
            depth(root);
            return maxDeep;
        }

        private int depth(TreeNode treeNode) {
            if (null == treeNode) {
                return 0;
            }
            int leftDeep = depth(treeNode.left);
            int rightDeep = depth(treeNode.right);
            maxDeep = Math.max(leftDeep + rightDeep, maxDeep);
            return Math.max(leftDeep, rightDeep) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (null == root) {
                return 0;
            }
            return maxDeep(root.left, root.right);
        }

        private int maxDeep(TreeNode left, TreeNode right) {
            if (null == left && null == right) {
                return 0;
            }
            if (null == left) {
                return maxTreeDeep(right);
            }
            if (null == right) {
                return maxTreeDeep(left);
            }
            return Math.max(maxTreeDeep(left) + maxTreeDeep(right), Math.max(maxDeep(left.left, left.right), maxDeep(right.left, right.right)));
        }

        private int maxTreeDeep(TreeNode node) {
            return null == node ? 0 : Math.max(maxTreeDeep(node.left), maxTreeDeep(node.right)) + 1;
        }
    }
}
