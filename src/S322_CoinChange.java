import java.util.Arrays;

public class S322_CoinChange {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     * 示例 1：输入：coins = [1, 2, 5], amount = 11  输出：3
     * 示例 2：输入：coins = [2], amount = 3  输出：-1
     * 示例 3：输入：coins = [1], amount = 0  输出：0
     * 示例 4：输入：coins = [1], amount = 1  输出：1
     * 示例 5：输入：coins = [1], amount = 2  输出：2
     * 提示：
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/

    public static void main(String[] args) {
        Solution solution = new S322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{1}, 1));
        System.out.println(solution.coinChange(new int[]{1}, 2));
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] tempArr = new int[max];
            tempArr[0] = 0;
            int coinLength = coins.length;
            for (int i = 1; i < max; i++) {
                tempArr[i] = max;
                for (int j = 0; j < coinLength; j++) {
                    if (i >= coins[j]) {
                        tempArr[i] = Math.min(tempArr[i], tempArr[i - coins[j]] + 1);
                    }
                }
            }
            return tempArr[amount] > amount ? -1 : tempArr[amount];
        }
    }
}