public class S172_TrailingZeroes {
    /**
     * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
     * <p>
     * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：0
     * 解释：3! = 6 ，不含尾随 0
     * 示例 2：
     * <p>
     * 输入：n = 5
     * 输出：1
     * 解释：5! = 120 ，有一个尾随 0
     * 示例 3：
     * <p>
     * 输入：n = 0
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/factorial-trailing-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));//0
        System.out.println(solution.trailingZeroes(5));//1
        System.out.println(solution.trailingZeroes(0));//0
    }

    static class Solution {
        public int trailingZeroes(int n) {
            int sum = 0;
            int temp;
            while ((temp = n / 5) > 0) {
                sum += temp;
                n = temp;
            }
            return sum;
        }
    }
}
