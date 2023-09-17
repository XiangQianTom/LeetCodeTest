import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S179_largestNumber {
    /**
     * 179. 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330
     * https://leetcode.cn/problems/largest-number/
     */
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.largestNumber(new int[]{10, 2}).equals("210"));
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}).equals("9534330"));
        System.out.println(solution.largestNumber(new int[]{1}).equals("1"));
        System.out.println(solution.largestNumber(new int[]{0, 0, 0}).equals("0"));
        System.out.println(solution.largestNumber(new int[]{111311, 1113}).equals("1113111311"));
        System.out.println(solution.largestNumber(new int[]{34323, 3432}).equals("343234323"));
        System.out.println(solution.largestNumber(new int[]{10, 2, 9, 39, 17}).equals("93921710"));
    }

    static class Solution2 {
        public String largestNumber(int[] nums) {
            PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
            for (int x : nums) heap.offer(String.valueOf(x));
            StringBuilder res = new StringBuilder();
            while (!heap.isEmpty()) res.append(heap.poll());
            if (res.charAt(0) == '0') return "0";
            return res.toString();
        }
    }

    static class Solution1 {
        public String largestNumber(int[] nums) {
            String result = Arrays.stream(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.joining());
            if (result.charAt(0) == '0') {
                return "0";
            }
            return result;
        }
    }

    static class Solution {
        public String largestNumber(int[] nums) {
            int length = nums.length;
            String[] numStr = new String[length];
            for (int i = 0; i < length; i++) {
                numStr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(numStr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });
//            String result = String.join("", numStr);
//            if (result.charAt(0) == '0') {
//                return "0";
//            }
//            return result;
            StringBuilder sb = new StringBuilder();
            for (String str : numStr) {
                sb.append(str);
            }
            if (sb.charAt(0) == '0') {
                return "0";
            }
            return sb.toString();
        }
    }
}
