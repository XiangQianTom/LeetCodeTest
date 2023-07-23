public class S5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abcdedcba"));
    }

    static class Solution {
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


        public String longestPalindrome2(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start + 1) {
                    start = i - (len - 1) / 2;
                    end = start + len - 1;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int len = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len = right - left + 1;
                left--;
                right++;
            }
            return len;
        }
    }
}
