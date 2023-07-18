import java.util.TreeSet;

public class S1675_MinimumDeviation {
    /**
     * 给你一个由 n 个正整数组成的数组 nums 。
     * <p>
     * 你可以对数组的任意元素执行任意次数的两类操作：
     * <p>
     * 如果元素是 偶数 ，除以 2
     * 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
     * 如果元素是 奇数 ，乘上 2
     * 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
     * 数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
     * 返回数组在执行某些操作之后可以拥有的 最小偏移量 。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：1
     * 解释：你可以将数组转换为 [1,2,3,2]，然后转换成 [2,2,3,2]，偏移量是 3 - 2 = 1
     * 示例 2：
     * <p>
     * 输入：nums = [4,1,5,20,3]
     * 输出：3
     * 解释：两次操作后，你可以将数组转换为 [4,2,5,5,3]，偏移量是 5 - 2 = 3
     * 示例 3：
     * <p>
     * 输入：nums = [2,10,8]
     * 输出：3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimize-deviation-in-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeviation(new int[]{1, 2, 3, 4}));//1
        System.out.println(solution.minimumDeviation(new int[]{4, 1, 5, 20, 3}));//3
        System.out.println(solution.minimumDeviation(new int[]{2, 10, 8}));//3
        System.out.println(solution.minimumDeviation(new int[]{3, 5}));//1
    }

    static class Solution {
        public int minimumDeviation(int[] nums) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : nums) {
                treeSet.add(num % 2 == 0 ? num : num * 2);
            }
            int sub = treeSet.last() - treeSet.first();
            while (sub > 0 && treeSet.last() % 2 == 0) {
                int last = treeSet.last();
                treeSet.remove(last);
                treeSet.add(last / 2);
                sub = Math.min(treeSet.last() - treeSet.first(), sub);
            }
            return sub;
        }
    }
}
