import java.util.Arrays;

public class S213_HouseRobberIi {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     * 示例 1：输入：nums = [2,3,2]  输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：输入：nums = [1,2,3,1]  输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：输入：nums = [0]  输出：0
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new S213_HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));//3
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));//4
        System.out.println(solution.rob(new int[]{0}));//0
        System.out.println(solution.rob(new int[]{1}));//1
        System.out.println(solution.rob(new int[]{2, 1}));//2
        System.out.println(solution.rob(new int[]{2, 1, 2}));//2
    }

    class Solution {

        public int rob1(int[] nums) {
            int length;
            if (null == nums || (length = nums.length) == 0) {
                return 0;
            }
            if (length == 1) {
                return nums[0];
            }
            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length - 1; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            if (length == 2) {
                return second;
            }
            int tempMax = second;
            first = nums[1];
            second = Math.max(nums[1], nums[2]);
            for (int i = 3; i < length; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return Math.max(tempMax, second);
        }

        public int rob(int[] nums) {
            int length;
            if (null == nums || (length = nums.length) == 0) {
                return 0;
            }
            if (length == 1) {
                return nums[0];
            }
            return Math.max(childRob(nums, 0, length - 1), childRob(nums, 1, length));
        }

        private int childRob(int[] nums, int start, int length) {
            int pre = 0;
            int max = 0;
            for (int i = start; i < length; i++) {
                int temp = max;
                max = Math.max(pre + nums[i], max);
                pre = temp;
            }
            return max;
        }
    }
}