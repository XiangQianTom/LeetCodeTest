import jdk.nashorn.internal.IntDeque;

import java.util.*;

public class S387_FirstUniqChar {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 示例：s = "leetcode"  返回 0
     * s = "loveleetcode"   返回 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("abcac"));
        System.out.println(solution.firstUniqChar("a"));
        System.out.println(solution.firstUniqChar("aadadaad"));
    }

    static class Solution {
        public int firstUniqChar1(String s) {
            int length;
            if (null == s || (length = s.length()) <= 0) {
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            int index = -1;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (sb.indexOf(c + "") == -1) {
                    sb.append(c);
                    int indexOf = s.indexOf(c, i + 1);
                    if (indexOf == -1) {
                        return i;
                    }
                }
            }
            return index;
        }

        public int firstUniqChar2(String s) {
            int length;
            if (null == s || (length = s.length()) <= 0) {
                return -1;
            }
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (s.indexOf(c) == s.lastIndexOf(c)) {
                    return i;
                }
            }
            return -1;
        }

        public int firstUniqChar3(String s) {
            int length;
            if (null == s || (length = s.length()) <= 0) {
                return -1;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (map.get(c) == 1) {
                    return i;
                }
            }
            return -1;
        }

        public int firstUniqChar4(String s) {
            int length;
            if (null == s || (length = s.length()) <= 0) {
                return -1;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, -1);
                } else {
                    map.put(c, i);
                }
            }
            int index = length;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value != -1) {
                    index = value < index ? value : index;
                }
            }
            return index == length ? -1 : index;
        }

        public int firstUniqChar(String s) {
            int[] arr = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                arr[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < length; i++) {
                if (arr[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}