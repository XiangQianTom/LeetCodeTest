import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 11, 7};
        int target = 9;
        int[] index = solution.twoSum2(nums, target);
        System.out.println(index[0] + " " + index[1]);
    }

    static class Solution {
        public int[] twoSum1(int[] nums, int target) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if ((nums[i] + nums[j]) == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }

        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int num = target - nums[i];
                if (map.containsKey(num)) {
                    return new int[]{i, map.get(num)};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
