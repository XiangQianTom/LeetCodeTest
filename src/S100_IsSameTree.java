import utils.TreeNode;
import utils.TreeNodeUtils;

public class S100_IsSameTree {
    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     * 示例 3：
     * <p>
     * <p>
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     * <p>
     * 作者：字节校园
     * 链接：https://leetcode.cn/leetbook/read/bytedance-c01/eicwcr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(
                TreeNodeUtils.buildTree(new Integer[]{1, 2, 3}), TreeNodeUtils.buildTree(new Integer[]{1, 2, 3})));//true
        System.out.println(solution.isSameTree(
                TreeNodeUtils.buildTree(new Integer[]{1, 2}), TreeNodeUtils.buildTree(new Integer[]{1, null, 2})));//false
        System.out.println(solution.isSameTree(
                TreeNodeUtils.buildTree(new Integer[]{1, 2, 1}), TreeNodeUtils.buildTree(new Integer[]{1, 1, 2})));//false
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p != null && q != null) {
                return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}
