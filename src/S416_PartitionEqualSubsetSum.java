public class S416_PartitionEqualSubsetSum {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 注意:
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:输入: [1, 5, 11, 5]  输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     * 示例 2:输入: [1, 2, 3, 5]  输出: false
     * 解释: 数组不能分割成两个元素和相等的子集.
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new S416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 1, 2, 2}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 8}));
    }

    class Solution {
        public boolean canPartition(int[] nums) {
            int length;
            if (null == nums || (length = nums.length) < 2) {
                return false;
            }
            int sum = 0, max = 0;
            for (int item : nums) {
                sum += item;
                max = Math.max(max, item);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }
            return knapSack(nums, length, target);
        }

        private boolean knapSack(int[] nums, int length, int sum) {
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 1; i < length; i++) {
                int num = nums[i];
                for (int j = sum; j >= num; j--) {
                    dp[j] = dp[j - num] || dp[j];
                }
            }
            return dp[sum];
        }
    }
}