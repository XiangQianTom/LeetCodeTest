import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S383_CanConstruct {
    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
     * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * 示例 1：输入：ransomNote = "a", magazine = "b" 输出：false
     * 示例 2：输入：ransomNote = "aa", magazine = "ab" 输出：false
     * 示例 3：输入：ransomNote = "aa", magazine = "aab" 输出：true
     * 提示：
     * 你可以假设两个字符串均只含有小写字母。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ransom-note
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canConstruct("a", "b"));
//        System.out.println(solution.canConstruct("aa", "aab"));
        System.out.println(solution.canConstruct("aa", "ab"));
    }

    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] indexs = new int[26];
            for (Character c : ransomNote.toCharArray()) {
                int fromIndex = c - 'a';
                int index = magazine.indexOf(c, indexs[fromIndex]);
                if (index == -1) {
                    return false;
                }
                indexs[fromIndex] = index + 1;
            }
            return true;
        }
    }
}
