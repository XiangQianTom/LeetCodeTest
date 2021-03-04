public class S35_SearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * <p>
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));//2
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));//1
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));//4
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));//0
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (null == nums) {
                return 0;
            }
            int insert = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] < target) {
                    insert = i + 1;
                }
            }
            return insert;
        }
    }
}