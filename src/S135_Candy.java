import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *  
 * <p>
 * 提示：
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S135_Candy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{4, 3, 2, 1}));//4
        System.out.println(solution.candy(new int[]{1}));
        System.out.println(solution.candy(new int[]{1, 0, 2}));//2,1,2
        System.out.println(solution.candy(new int[]{0, 1, 2}));//1,2,1
        System.out.println(solution.candy(new int[]{1, 2, 2}));
        System.out.println(solution.candy(new int[]{0, 1, 2, 3, 4, 5}));
    }

    static class Solution {
        public int candy(int[] ratings) {
            int length = ratings.length;
            int[] temp = new int[length];
            Arrays.fill(temp, 1);
            for (int i = 1; i < length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    temp[i] = temp[i - 1] + 1;
                }
            }
            for (int i = length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    temp[i] = Math.max(temp[i], temp[i + 1] + 1);
                }
            }
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += temp[i];
            }
            return sum;
        }
    }
}
