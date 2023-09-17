import java.util.Arrays;

public class S976_largestPerimeter {
    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
     * 示例 1：
     * 输入：nums = [2,1,2]
     * 输出：5
     * 解释：你可以用三个边长组成一个三角形:1 2 2。
     * 示例 2：
     * 输入：nums = [1,2,1,10]
     * 输出：0
     * 解释：
     * 你不能用边长 1,1,2 来组成三角形。
     * 不能用边长 1,1,10 来构成三角形。
     * 不能用边长 1、2 和 10 来构成三角形。
     * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
     * https://leetcode.cn/problems/largest-perimeter-triangle/
     */
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.largestPerimeter(new int[]{2, 1, 2}));// 5
        System.out.println(solution.largestPerimeter(new int[]{1, 2, 1, 10}));// 0
        System.out.println(solution.largestPerimeter(new int[]{3, 2, 3, 4}));// 10
    }

    static class Solution1 {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i] < nums[i - 1] + nums[i - 2])
                    return nums[i] + nums[i - 1] + nums[i - 2];
            }
            return 0;
        }
    }

    static class Solution {
        public int largestPerimeter(int[] nums) {
            Integer[] array = Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).toArray(Integer[]::new);
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] < array[i + 1] + array[i + 2]) {
                    return array[i] + array[i + 1] + array[i + 2];
                }
            }
            return 0;
        }
    }
}
