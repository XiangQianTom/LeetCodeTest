import java.util.HashMap;
import java.util.Map;

public class S7_IntegerInversion {
    /**
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(-1));
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(98));
        System.out.println(solution.reverse(214748366));
        System.out.println(solution.reverse(-2147483648));
    }
}

class Solution {
    public int reverse(int x) {
        int n = 0;
        int temp;
        while (x != 0) {
            temp = n;
            n = x % 10 + n * 10;
            if (n / 10 != temp) return 0;
            x /= 10;
        }
        return n;
    }

    public int reverse1(int x) {
        StringBuilder sb = new StringBuilder(x + "");
        String numStr = sb.reverse().toString().replace("-", "");
        if (x < 0) {
            numStr = "-" + numStr;
        }
        long n = Long.parseLong(numStr);
        if (n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) n;
    }
}
