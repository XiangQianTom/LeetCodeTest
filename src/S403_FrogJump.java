import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S403_FrogJump {
    /**
     * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
     * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
     * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
     * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
     * 示例 1：输入：stones = [0,1,3,5,6,8,12,17]  输出：true
     * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
     * 示例 2：输入：stones = [0,1,2,3,4,8,9,11]  输出：false
     * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
     * 提示：
     * 2 <= stones.length <= 2000
     * 0 <= stones[i] <= 231 - 1
     * stones[0] == 0
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/frog-jump
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new S403_FrogJump().new Solution();
        System.out.println(solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));//true
        System.out.println(solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));//false
        System.out.println(solution.canCross(new int[]{0, 2, 3, 1, 1, 4}));//true
        System.out.println(solution.canCross(new int[]{0, 3, 2, 1, 0, 4}));//true
    }

    class Solution {
        public boolean canCross1(int[] stones) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < stones.length; i++) {
                map.put(stones[i], new HashSet<>());
            }
            map.get(0).add(0);
            for (int i = 0; i < stones.length; i++) {
                for (Integer k : map.get(stones[i])) {
                    for (int step = k - 1; step <= k + 1; step++) {
                        Set<Integer> steps = map.get(step + stones[i]);
                        if (step > 0 && null != steps) {
                            steps.add(step);
                        }
                    }
                }
            }
            return !map.get(stones[stones.length - 1]).isEmpty();
        }

        public boolean canCross(int[] stones) {
            int len = stones.length;
            if (stones[1] != 1) {
                return false;
            }
            boolean[][] dp = new boolean[len][len + 1];
            dp[0][0] = true;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    int k = stones[i] - stones[j];
                /*
                	为什么有这么个判断？
                	因为其他石头跳到第 i 个石头跳的步数 k 必定满足 k <= i
                	这又是为什么？
                	1、比如 nums = [0,1,3,5,6,8,12,17]
                	   那么第 0 个石头跳到第 1 个石头，步数肯定为 1，然后由于后续最大的步数是 k + 1，因此第 1 个石头最大只能跳 2 个单位
                 	   因此如果逐个往上加，那么第 2 3 4 5 ... 个石头最多依次跳跃的步数是 3 4 5 6...
                	2、 第 i 个石头能跳的最大的步数是 i + 1，那么就意味着其他石头 j 跳到第 i 个石头的最大步数只能是 i 或者 j + 1
                	   而 这个 k 是其他石头跳到 i 石头上来的，因此 k 必须 <= i （或者是 k <= j + 1）
                */
                    if (k <= i) {
                        dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                        //提前结束循环直接返回结果
                        if (i == len - 1 && dp[i][k]) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

}