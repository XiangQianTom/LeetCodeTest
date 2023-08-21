import utils.TreeNode;

import java.util.*;

public class S863_distanceK {
    /**
     * 863. 二叉树中所有距离为 K 的结点
     * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
     * 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
     * 示例 1：
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
     * 输出：[7,4,1]
     * 解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
     * 示例 2:
     * 输入: root = [1], target = 1, k = 3
     * 输出: []
     * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(solution.distanceK(root, root.findTreeNode(5), 2));//[7,4,1]
        root = TreeNode.buildTree(new Integer[]{1});
        System.out.println(solution.distanceK(root, root.findTreeNode(1), 3));//[]
        root = TreeNode.buildTree(new Integer[]{0, 1, null, null, 2, null, 3, null, 4});
        System.out.println(solution.distanceK(root, root.findTreeNode(2), 2));//[4,0]
        root = TreeNode.buildTree(new Integer[]{0, null, 1, null, 2, null, 3});
        System.out.println(solution.distanceK(root, root.findTreeNode(1), 2));//[3]
        root = TreeNode.buildTree(new Integer[]{0, 1, null, null, 2, null, 3, null, 4});
        System.out.println(solution.distanceK(root, root.findTreeNode(3), 0));//[3]
        root = TreeNode.buildTree(new Integer[]{0, null, 1, 2, 5, null, 3, null, null, null, 4});
        System.out.println(solution.distanceK(root, root.findTreeNode(2), 2));//[4,5,0]
    }

    static class Solution {
        Map<Integer, TreeNode> parentMap;
        List<Integer> res;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            parentMap = new HashMap<>();
            res = new ArrayList<>();
            findParent(root);
            dfs(target, null, k);
            return res;
        }

        private void findParent(TreeNode root) {
            if (null == root) {
                return;
            }
            if (root.left != null) {
                parentMap.put(root.left.val, root);
                findParent(root.left);
            }
            if (root.right != null) {
                parentMap.put(root.right.val, root);
                findParent(root.right);
            }
        }

        private void dfs(TreeNode target, TreeNode pre, int k) {
            if (null == target) {
                return;
            }
            if (k == 0) {
                res.add(target.val);
            }
            if (target.left != pre) {
                dfs(target.left, target, k - 1);
            }
            if (target.right != pre) {
                dfs(target.right, target, k - 1);
            }
            TreeNode parent = parentMap.get(target.val);
            if (parent != pre) {
                dfs(parent, target, k - 1);
            }
        }
    }
}
