public class S344_ReverseString {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * 示例 1：
     * 输入：["h","e","l","l","o"]  输出：["o","l","l","e","h"]
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]  输出：["h","a","n","n","a","H"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution, new char[]{'h', 'e', 'l', 'l', 'o', 'a', 'd', 'e'});
    }

    private static void test(Solution solution, char[] chars) {
        solution.reverseString(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    static class Solution {
        public void reverseString1(char[] s) {
            int leftIndex = 0;
            int rightIndex = s.length - 1;
            while (leftIndex < s.length / 2) {
                char temp = s[leftIndex];
                s[leftIndex] = s[rightIndex];
                s[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }

        public void reverseString(char[] s) {
            int n = s.length;
            for (int i = 0; i < n / 2; ++i) {
                int j = n - 1 - i;
                s[i] ^= s[j];
                s[j] ^= s[i];
                s[i] ^= s[j];
            }
        }
    }
}
