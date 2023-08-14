import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S971_FlipMatchVoyage {
    /**
     * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
     * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
     * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
     * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
     * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
     * 示例 1：
     * 输入：root = [1,2], voyage = [2,1]
     * 输出：[-1]
     * 解释：翻转节点无法令先序遍历匹配预期行程。
     * 示例 2：
     * 输入：root = [1,2,3], voyage = [1,3,2]
     * 输出：[1]
     * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
     * 示例 3：
     * 输入：root = [1,2,3], voyage = [1,2,3]
     * 输出：[]
     * 解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
     * 作者：字节校园
     * 链接：https://leetcode.cn/leetbook/read/bytedance-c01/eu1a7s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution().flipMatchVoyage(TreeNode.buildTree(new Integer[]{1, 2}), new int[]{2, 1}));
        System.out.println(new Solution().flipMatchVoyage(TreeNode.buildTree(new Integer[]{1, 2, 3}), new int[]{1, 3, 2}));
        System.out.println(new Solution().flipMatchVoyage(TreeNode.buildTree(new Integer[]{1, 2, 3}), new int[]{1, 2, 3}));
    }

    static class Solution {
        List<Integer> res;
        int index;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            res = new ArrayList<>();
            return dfs(root, voyage) ? res : Arrays.asList(-1);
        }

        private boolean dfs(TreeNode root, int[] voyage) {
            if (root == null)
                return true;
            if (root.val != voyage[index])
                return false;
            index++;
            if (root.left != null && root.left.val != voyage[index]) {
                res.add(root.val);
                return dfs(root.right, voyage) && dfs(root.left, voyage);
            } else {
                return dfs(root.left, voyage) && dfs(root.right, voyage);
            }
        }
    }
}
