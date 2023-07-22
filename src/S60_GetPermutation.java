public class S60_GetPermutation {
    /**
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3, k = 3
     * 输出："213"
     * 示例 2：
     * <p>
     * 输入：n = 4, k = 9
     * 输出："2314"
     * 示例 3：
     * <p>
     * 输入：n = 3, k = 1
     * 输出："123"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/permutation-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));//213
        System.out.println(solution.getPermutation(4, 9));//2314
        System.out.println(solution.getPermutation(3, 1));//123
    }

    static class Solution {
        public String getPermutation(int n, int k) {
            return backtrack(new StringBuilder(), new int[n + 1], n, k);
        }

        private String backtrack(StringBuilder sb, int[] used, int n, int k) {
            int length = sb.length();
            if (length == n) {
                return sb.toString();
            }
            int factorial = factorial(n - length - 1);
            for (int i = 1; i <= n; i++) {
                if (used[i] == 1) {
                    continue;
                }
                if (factorial < k) {
                    i += k / factorial - 1;
                    k %= factorial;
                    continue;
                }
                used[i] = 1;
                sb.append(i);
                return backtrack(sb, used, n, k);
            }
            return "";
        }

        private int factorial(int num) {
            int result = 1;
            for (int i = 2; i <= num; i++) {
                result *= i;
            }
            return result;
        }
    }
}
