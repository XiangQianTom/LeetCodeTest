public class S5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new S5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            int maxLength = 1;
            int left = 0;
            char[] chars = s.toCharArray();
            for (int j = 1; j < length; j++) {
                for (int i = 0; i < j; i++) {
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    int childLen;
                    if (dp[i][j] && (childLen = j - i + 1) > maxLength) {
                        maxLength = childLen;
                        left = i;
                    }
                }
            }
            return s.substring(left, left + maxLength);
        }
    }
}