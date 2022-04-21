import java.util.Arrays;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S435_EraseOverlapIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            int end = intervals[0][1];
            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (end <= intervals[i][0]) {
                    end = intervals[i][1];
                } else {
                    count++;
                }
            }
            return count;
        }

        public int eraseOverlapIntervals1(int[][] intervals) {
            int length = intervals.length;
            if (length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            int end = intervals[0][1];
            int count = 1;
            for (int i = 1; i < length; i++) {
                if (end <= intervals[i][0]) {
                    end = intervals[i][1];
                    count++;
                }
            }
            return length - count;
        }
    }
}
