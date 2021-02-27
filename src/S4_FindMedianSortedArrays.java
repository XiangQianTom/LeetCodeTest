/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S4_FindMedianSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int len1 = nums1.length;
            int len2 = nums2.length;
            int totalLeft = (len1 + len2 + 1) / 2;//分割线左边个数一定
            int left = 0;
            int right = len1;
            int i, j;
            while (left < right) {
                i = (left + right + 1) / 2;
                j = totalLeft - i;
                if (nums1[i - 1] > nums2[j]) {
                    right = i - 1;
                } else {
                    left = i;
                }
            }

            i = left;
            j = totalLeft - i;

            int leftLine1 = getValue(nums1, i - 1 < 0, Integer.MIN_VALUE, i - 1);
            int rightLine1 = getValue(nums1, i == len1, Integer.MAX_VALUE, i);
            int leftLine2 = getValue(nums2, j - 1 < 0, Integer.MIN_VALUE, j - 1);
            int rightLine2 = getValue(nums2, j == len2, Integer.MAX_VALUE, j);

            if ((len1 + len2) % 2 == 0) {
                return (double) (Math.max(leftLine1, leftLine2) + Math.min(rightLine1, rightLine2)) / 2;
            } else {
                return Math.max(leftLine1, leftLine2);
            }
        }

        private int getValue(int[] nums, boolean invalid, int discardValue, int index) {
            return invalid ? discardValue : nums[index];
        }
    }
}
