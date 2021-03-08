import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：输入：s = "Hello World"  输出：5
 * 示例 2：输入：s = " "  输出：0
 * 提示：1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S58_LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hell Hello Worlda"));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord("abc "));
    }

    static class Solution {
        public int lengthOfLastWord1(String s) {
            String[] split = s.split(" ");
            int length = 0;
            for (int i = split.length - 1; i >= 0; i--) {
                if (isWord(split[i])) {
                    length = split[i].length();
                    break;
                }
            }
            return length;
        }

        public int lengthOfLastWord2(String s) {
            int length = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    length++;
                } else if (length != 0) {
                    break;
                }
            }
            return length;
        }

        public int lengthOfLastWord(String s) {
            String[] split = s.split(" ");
            int length = 0;
            for (int i = split.length - 1; i >= 0; i--) {
                if (!split[i].equals(" ")) {
                    length = split[i].length();
                    break;
                }
            }
            return length;
        }

        private boolean isWord(String str) {
            return str.replaceAll("^[A-Za-z]+$", "").length() == 0;
        }
    }
}
