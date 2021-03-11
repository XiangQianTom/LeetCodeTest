import java.util.HashMap;
import java.util.Map;

public class S415_AddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和 num2 ，计算它们的和。
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("18", "23"));
        System.out.println(solution.addStrings("0", "9"));
        System.out.println(solution.addStrings("99", "99"));
    }

    static class Solution {
        public String addStrings1(String num1, String num2) {
            if (num1 == null || num1.length() == 0) return num2;
            if (num2 == null || num2.length() == 0) return num1;

            StringBuilder stb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;

            int c = 0;
            while (i >= 0 || j >= 0) {
                if (i >= 0) c += num1.charAt(i--) - '0';
                if (j >= 0) c += num2.charAt(j--) - '0';
                stb.append(c % 10);
                c = c + 6;
                c >>= 4;
            }
            String res = stb.reverse().toString();
            return c > 0 ? '1' + res : res;
        }

        public String addStrings2(String num1, String num2) {
            if (num1 == null || num1.length() == 0) return num2;
            if (num2 == null || num2.length() == 0) return num1;

            StringBuilder stb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;

            int c = 0;
            while (i >= 0 || j >= 0) {
                if (i >= 0) c += num1.charAt(i--) - '0';
                if (j >= 0) c += num2.charAt(j--) - '0';
                stb.append(c % 10);
                c /= 10;
            }
            String res = stb.reverse().toString();
            return c > 0 ? '1' + res : res;
        }

        public String addStrings(String num1, String num2) {
            String longer;
            String shorter;
            if (num1.length() > num2.length()) {
                longer = num1;
                shorter = num2;
            } else {
                longer = num2;
                shorter = num1;
            }
            int i = longer.length() - 1;
            int j = shorter.length() - 1;
            int overflow = 0;
            StringBuilder sb = new StringBuilder();
            while (j >= 0) {
                overflow = overflow + longer.charAt(i) + shorter.charAt(j) - '0' - '0';
                sb.append(overflow % 10);
                overflow = overflow + 6;
                overflow >>= 4;
                i--;
                j--;
            }
            while (i >= 0) {
                overflow = overflow + longer.charAt(i) - '0';
                sb.append(overflow % 10);
                overflow = overflow + 6;
                overflow >>= 4;
                i--;
            }
            String res = sb.reverse().toString();
            return overflow > 0 ? '1' + res : res;
        }
    }
}