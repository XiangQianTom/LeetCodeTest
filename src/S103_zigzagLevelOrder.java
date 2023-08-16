import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S103_zigzagLevelOrder {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
     * 示例 2：
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * 输入：root = []
     * 输出：[]
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder1(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.zigzagLevelOrder1(TreeNode.buildTree(new Integer[]{1})));
        System.out.println(solution.zigzagLevelOrder1(TreeNode.buildTree(new Integer[]{})));
        System.out.println(solution.zigzagLevelOrder1(TreeNode.buildTree(new Integer[]{1, 2, 3, 4, null, null, 5})));
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) queue.add(root);
            while (!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) tmp.addLast(node.val);
                    else tmp.addFirst(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }

        public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
            List<List<Integer>> data = new ArrayList<>();
            zigzagLevel(root, 0, data);
            return data;
        }

        private void zigzagLevel(TreeNode treeNode, int heigh, List<List<Integer>> data) {
            if (null == treeNode) {
                return;
            }
            if (data.size() == heigh) {
                data.add(new ArrayList<>());
            }
            if ((heigh & 1) == 1) {
                data.get(heigh).add(0, treeNode.val);
            } else {
                data.get(heigh).add(treeNode.val);
            }
            zigzagLevel(treeNode.left, heigh + 1, data);
            zigzagLevel(treeNode.right, heigh + 1, data);
        }
    }
}
