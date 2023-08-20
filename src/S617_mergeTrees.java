import utils.TreeNode;

public class S617_mergeTrees {
    /**
     * 617. 合并二叉树
     * 给你两棵二叉树： root1 和 root2 。
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     * 返回合并后的二叉树。
     * 注意: 合并过程必须从两个树的根节点开始。
     * 示例 1：
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     * 示例 2：
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
     * https://leetcode.cn/problems/merge-two-binary-trees/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mergeTrees1(TreeNode.buildTree(new Integer[]{1, 3, 2, 5}),
                TreeNode.buildTree(new Integer[]{2, 1, 3, null, 4, null, 7})).printTree();
        solution.mergeTrees1(TreeNode.buildTree(new Integer[]{1}),
                TreeNode.buildTree(new Integer[]{1, 2})).printTree();
    }

    static class Solution {
        public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
            if (null == root1) {
                return root2;
            }
            if (null == root2) {
                return root1;
            }
            return new TreeNode(root1.val + root2.val,
                    mergeTrees1(root1.left, root2.left),
                    mergeTrees1(root1.right, root2.right));
        }

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (null == root1) {
                return root2;
            }
            if (null == root2) {
                return root1;
            }
            root1.val = root1.val + root2.val;
            if (root1.left == null && root2.left != null) {
                root1.left = new TreeNode(0);
            }
            mergeTrees(root1.left, root2.left);

            if (root1.right == null && root2.right != null) {
                root1.right = new TreeNode(0);
            }
            mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
