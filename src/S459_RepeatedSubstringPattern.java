import java.util.Arrays;
import java.util.jar.JarEntry;

public class S459_RepeatedSubstringPattern {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例 1:输入: "abab"  输出: True  解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:输入: "aba"  输出: False
     * 示例 3:输入: "abcabcabcabc"  输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abab"));//true
        System.out.println(solution.repeatedSubstringPattern("aba"));//false
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));//true
        System.out.println(solution.repeatedSubstringPattern("aaa"));//true
        System.out.println(solution.repeatedSubstringPattern(""));//false
        System.out.println(solution.repeatedSubstringPattern("a"));//false
        System.out.println(solution.repeatedSubstringPattern("abacabac"));//true
    }

    static class Solution {
        public boolean repeatedSubstringPattern1(String s) {
            int length = s.length();
            if (length <= 1) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            char first = s.charAt(0);
            sb.append(first);
            for (int i = 1; i < length; i++) {
                char c = s.charAt(i);
                if (first == c) {
                    if (length % i == 0) {
                        String child = sb.toString();
                        int times = length / i;
                        int j;
                        for (j = 1; j < times; j++) {
                            if (s.indexOf(child, j * i) != j * i) {
                                break;
                            }
                        }
                        if (times == j) {
                            return true;
                        } else {
                            sb.append(c);
                        }
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }
            return false;
        }

        public boolean repeatedSubstringPattern2(String s) {
            int length = s.length();
            if (length <= 1) {
                return false;
            }
            return (s + s).substring(1, s.length() * 2 - 1).contains(s);
        }

        public boolean repeatedSubstringPattern3(String s) {
            int n = s.length();
            for (int i = 1; i * 2 <= n; ++i) {
                if (n % i == 0) {
                    boolean match = true;
                    for (int j = i; j < n; ++j) {
                        if (s.charAt(j) != s.charAt(j - i)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean repeatedSubstringPattern(String s) {
            return kmp(s + s, s);
        }

        private boolean kmp(String query, String pattern) {
            int n = query.length();
            int m = pattern.length();
            int[] fail = new int[m];
            Arrays.fill(fail, -1);
            for (int i = 1; i < m; ++i) {
                int j = fail[i - 1];
                while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                    j = fail[j];
                }
                if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int match = -1;
            for (int i = 1; i < n - 1; ++i) {
                while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                    match = fail[match];
                }
                if (pattern.charAt(match + 1) == query.charAt(i)) {
                    ++match;
                    if (match == m - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}