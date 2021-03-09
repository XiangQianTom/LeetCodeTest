public class S125_IsPalindrome {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:输入: "A man, a plan, a canal: Panama"  输出: true
     * 示例 2:输入: "race a car"  输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    static class Solution {
        public boolean isPalindrome1(String s) {
            String value = s.replaceAll("[^0-9a-zA-Z]+", "").toUpperCase();
            int length = value.length();
            for (int i = 0, j = length - 1; i < length / 2 && j >= (length / 2 - length % 2); i++, j--) {
                if (value.charAt(i) != value.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isPalindrome(String s) {
            int leftIndex = 0;
            int rightStartIndex = s.length() - 1;
            int rightIndex = rightStartIndex;
            while (true) {
                char leftChar = ' ';
                while (leftIndex <= rightStartIndex && !isLegalChar(leftChar = s.charAt(leftIndex))) {
                    leftIndex++;
                }
                char rightChar = ' ';
                while (rightIndex >= 0 && !isLegalChar(rightChar = s.charAt(rightIndex))) {
                    rightIndex--;
                }
                if (leftIndex > rightIndex) {
                    return true;
                }
                leftIndex++;
                rightIndex--;
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
            }
        }

        public boolean isLegalChar(char c) {
            return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }
    }
}
