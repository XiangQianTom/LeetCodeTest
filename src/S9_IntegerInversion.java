public class S9_IntegerInversion {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(" " + solution.isPalindrome(-56765));
        System.out.println(" " + solution.isPalindrome(56765));
        System.out.println(" " + solution.isPalindrome(12345));
        System.out.println(" " + solution.isPalindrome(1234554321));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int n = 0;
            while (x > n) {
                n = n * 10 + x % 10;
                x /= 10;
            }
            return n == x || n / 10 == x;
        }
    }
}
