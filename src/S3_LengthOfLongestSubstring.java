import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(solution.lengthOfLongestSubstring(""));//0
        System.out.println(solution.lengthOfLongestSubstring(" "));//1
        System.out.println(solution.lengthOfLongestSubstring("au"));//2
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));//3
        System.out.println(solution.lengthOfLongestSubstring("abcabcdbb"));//4
        System.out.println(solution.lengthOfLongestSubstring("abcabcfdabcdbb"));//5
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || s.length() == 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            List<Character> list = new ArrayList<>();
            int length = chars.length;
            int finalLength = 1;
            for (int i = 0; i < length; i++) {
                list.add(chars[i]);
                for (int j = i + 1; j < length; j++) {
                    boolean needContinue = true;
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) == chars[j]) {
                            needContinue = false;
                            break;
                        }
                    }
                    if (!needContinue) {
                        break;
                    }
                    list.add(chars[j]);
                }
                int size = list.size();
                if (finalLength < size) {
                    finalLength = size;
                }
                list.clear();
            }
            return finalLength;
        }
    }

    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128];
            int res = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index]);
                res = Math.max(res, i - start + 1);
                last[index] = i + 1;
            }
            return res;
        }
    }
}
