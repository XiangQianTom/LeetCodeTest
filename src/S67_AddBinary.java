public class S67_AddBinary {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 示例  1:输入: a = "11", b = "1"  输出: "100"
     * 示例  2:输入: a = "1010", b = "1011"  输出: "10101"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-binary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11111", "11"));//"100010"
        System.out.println(solution.addBinary("1010", "1011"));
    }

    static class Solution {
        public String addBinary1(String a, String b) {
            int firstLength = a.length();
            int secondLength = b.length();
            StringBuilder sb = new StringBuilder();
            int base = 0;
            for (int i = 0; i < Math.max(firstLength, secondLength); i++) {
                int sum = getInt(i, firstLength, a) + getInt(i, secondLength, b) + base;
                if (sum > 1) {
                    sum = sum % 2;
                    base = 1;
                } else {
                    base = 0;
                }
                sb.insert(0, sum);
            }
            if (base != 0) {
                sb.insert(0, base);
            }
            return sb.toString();
        }

        public String addBinary(String a, String b) {
            if (a == null || a.length() == 0) return b;
            if (b == null || b.length() == 0) return a;

            StringBuilder stb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;

            int c = 0;
            while (i >= 0 || j >= 0) {
                if (i >= 0) c += a.charAt(i--) - '0';
                if (j >= 0) c += b.charAt(j--) - '0';
                stb.append(c % 2);
                c >>= 1;
            }
            String res = stb.reverse().toString();
            return c > 0 ? '1' + res : res;
        }

        private int getInt(int index, int length, String str) {
            try {
                return str.charAt(length - index - 1) - 48;
            } catch (Exception e) {
                return 0;
            }
        }
    }
}
