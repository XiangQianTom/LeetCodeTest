import java.util.HashMap;
import java.util.Map;

public class S242_isAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 链接：https://leetcode.cn/problems/valid-anagram
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int length = s.length();
            if (length != t.length()) {
                return false;
            }
            int[] dp = new int[26];
            for (int i = 0; i < length; i++) {
                dp[s.charAt(i) - 97]++;
            }
            for (int i = 0; i < length; i++) {
                dp[t.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++) {
                if (dp[i] != 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram1(String s, String t) {
            int length = s.length();
            if (length != t.length()) {
                return false;
            }
            int[] dp = new int[26];
            for (int i = 0; i < length; i++) {
                dp[s.charAt(i) - 97]++;
            }
            for (int i = 0; i < length; i++) {
                int key = t.charAt(i) - 97;
                dp[key]--;
                if (dp[key] < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram2(String s, String t) {
            int length = s.length();
            if (length != t.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                Integer count = map.get(c);
                if (null == count) {
                    count = 0;
                }
                map.put(c, ++count);
            }
            for (int i = 0; i < length; i++) {
                char c = t.charAt(i);
                Integer count = map.get(c);
                if (null == count) {
                    return false;
                }
                if (--count < 0) {
                    return false;
                }
                map.put(c, count);
            }
            return true;
        }
    }
}
