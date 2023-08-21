import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S113_pathSum {
    /**
     * 113. 路径总和 II
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * 示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     * https://leetcode.cn/problems/path-sum-ii/
     */
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1, 2}), 0));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1}), -1));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1, 2}), 1));
        System.out.println(solution.pathSum(TreeNode.buildTree(new Integer[]{1, 2, 4}), 3));
    }

    static class Solution1 {
        List<List<Integer>> result;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            pathSum(root, targetSum, 0, new ArrayList<>());
            return result;
        }

        private void pathSum(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> list) {
            if (null == root) {
                return;
            }
            currentSum += root.val;
            list.add(root.val);
            if (currentSum == targetSum && root.left == null && root.right == null) {
                result.add(new ArrayList<>(list));
            } else {
                pathSum(root.left, targetSum, currentSum, list);
                pathSum(root.right, targetSum, currentSum, list);
            }
            list.remove(list.size() - 1);
        }
    }

    static class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            pathSum(root, targetSum, 0, new ArrayList<>());
            return result;
        }

        private void pathSum(TreeNode root, int targetSum, int currentSum, List<Integer> last) {
            if (null == root) {
                return;
            }
            currentSum = currentSum + root.val;
            List<Integer> tem = new ArrayList<>(last);
            tem.add(root.val);
            if (currentSum == targetSum && root.left == null && root.right == null) {
                result.add(tem);
            } else {
                pathSum(root.left, targetSum, currentSum, tem);
                pathSum(root.right, targetSum, currentSum, tem);
            }
        }
    }
}
