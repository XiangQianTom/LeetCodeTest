import java.util.LinkedList;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 *  
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S402_RemoveKdigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));//1219
        System.out.println(solution.removeKdigits("10200", 1));//200
        System.out.println(solution.removeKdigits("10", 2));//0
        System.out.println(solution.removeKdigits("4829385", 3));//2385
    }

    static class Solution {
        public String removeKdigits(String num, int k) {
            LinkedList<Character> stack = new LinkedList<Character>();
            int length = num.length();
            for (int i = 0; i < length; i++) {
                char c = num.charAt(i);
                while (!stack.isEmpty() && stack.peekLast() > c && k > 0) {
                    stack.pollLast();
                    k--;
                }
                stack.offer(c);
            }
            for (int i = 0; i < k; i++) {
                stack.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            boolean headZero = true;
            while (stack.size() > 0) {
                Character character = stack.pollFirst();
                if (headZero && character == '0') {
                    continue;
                }
                headZero = false;
                sb.append(character);
            }
            String result = sb.toString();
            return result.length() == 0 ? "0" : result;
        }
    }
}
