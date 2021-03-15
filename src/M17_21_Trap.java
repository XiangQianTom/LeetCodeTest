import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;

public class M17_21_Trap {
    /**
     * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 2, 0}));//0
        System.out.println(solution.trap(new int[]{2, 2, 2}));//0
        System.out.println(solution.trap(new int[]{2, 0, 2}));//2
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));//6
        System.out.println(solution.trap(new int[]{4, 3, 2, 1, 0, 1, 5, 6}));//13
        System.out.println(solution.trap(new int[]{5, 7, 5, 3, 1, 1, 3, 1, 1, 1}));//4
        System.out.println(solution.trap(new int[]{1, 24, 34, 3, 6, 2, 8, 5, 8, 2, 3, 5, 3, 4, 1}));//22
    }

    static class Solution {
        public int trap1(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < length; i++) {
                if (height[i] > max) {
                    max = height[i];
                    maxIndex = i;
                }
            }
            int sum = 0;
            int leftIndex = maxIndex;
            int leftStartMax = max;
            while ((--leftIndex) >= 0) {
                int leftMax = 0;
                int leftMaxIndex = 0;
                for (int j = leftIndex; j >= 0; j--) {
                    if (height[j] > leftMax) {
                        leftMax = height[j];
                        leftMaxIndex = j;
                    }
                }
                sum = getSum(height, sum, leftMaxIndex, leftStartMax, leftMax, leftIndex);
                leftIndex = leftMaxIndex;
                leftStartMax = leftMax;
            }
            int rightIndex = maxIndex;
            int rightStartMax = max;
            while ((++rightIndex) < length) {
                int rightMax = 0;
                int rightMaxIndex = length - 1;
                for (int j = rightIndex; j < length; j++) {
                    if (height[j] > rightMax) {
                        rightMax = height[j];
                        rightMaxIndex = j;
                    }
                }
                sum = getSum(height, sum, rightIndex, rightStartMax, rightMax, rightMaxIndex);
                rightIndex = rightMaxIndex;
                rightStartMax = rightMax;
            }
            return sum;
        }

        public int trap2(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }
            int sum = 0;
            for (int i = 1; i < length - 1; i++) {
                int leftMax = 0;
                for (int j = 0; j < i; j++) {
                    if (leftMax < height[j]) {
                        leftMax = height[j];
                    }
                }
                int rightMax = 0;
                for (int j = i + 1; j < length; j++) {
                    if (rightMax < height[j]) {
                        rightMax = height[j];
                    }
                }
                sum += Math.max(Math.min(leftMax, rightMax) - height[i], 0);
            }
            return sum;
        }

        public int trap3(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }
            int[] leftArr = new int[length];
            leftArr[0] = height[0];
            for (int i = 1; i < length; i++) {
                leftArr[i] = Math.max(leftArr[i - 1], height[i]);
            }
            int[] rightArr = new int[length];
            rightArr[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                rightArr[i] = Math.max(rightArr[i + 1], height[i]);
            }
            int sum = 0;
            for (int i = 1; i < length - 1; i++) {
                sum += Math.max(Math.min(leftArr[i - 1], rightArr[i + 1]) - height[i], 0);
            }
            return sum;
        }

        public int trap(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }
            int sum = 0;
            int leftMax = height[0];
            int rightMax = height[length - 1];
            for (int i = 0, j = length - 2; i <= j; ) {
                if (leftMax > rightMax) {
                    sum += Math.max(rightMax - height[j], 0);
                    rightMax = Math.max(rightMax, height[j--]);
                } else {
                    sum += Math.max(leftMax - height[i], 0);
                    leftMax = Math.max(leftMax, height[i++]);
                }
            }
            return sum;
        }

        private int getSum(int[] height, int sum, int rightIndex, int rightStartMax, int rightMax, int rightMaxIndex) {
            int chileSum = 0;
            int chileCount = 0;
            int lower = Math.min(rightStartMax, rightMax);
            for (int j = rightIndex; j <= rightMaxIndex; j++) {
                if (height[j] < lower) {
                    chileCount++;
                    chileSum += height[j];
                }
            }
            sum = sum + chileCount * lower - chileSum;
            return sum;
        }
    }
}
