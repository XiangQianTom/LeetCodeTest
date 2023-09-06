import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S56_merge {
    /**
     * 56. 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * https://leetcode.cn/problems/merge-intervals/
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        solution.print(new int[][]{{1, 4}, {4, 5}});
    }

    static class Solution {
        public void print(int[][] intervals) {
            int[][] merge = merge(intervals);
            for (int[] ints : merge) {
                System.out.print("[");
                for (int i = 0; i < ints.length; i++) {
                    System.out.print(ints[i] + (i == ints.length - 1 ? "" : ","));
                }
                System.out.print("]");
            }
            System.out.println();
        }

        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            List<int[]> list = new ArrayList<>();
            int[] current = intervals[0];
            list.add(current);
            for (int i = 1; i < intervals.length; i++) {
                int currentEnd = current[1];
                int[] next = intervals[i];
                if (currentEnd >= next[0]) {
                    current[1] = Math.max(currentEnd, next[1]);
                } else {
                    current = next;
                    list.add(current);
                }
            }
            return list.toArray(new int[][]{});
        }
    }
}
