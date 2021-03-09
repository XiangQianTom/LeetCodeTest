public class S345_ReverseVowels {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * 示例 1：输入："hello"  输出："holle"
     * 示例 2：输入："leetcode"  输出："leotcede"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }

    static class Solution {
        public String reverseVowels(String s) {
            int leftIndex = 0;
            int rightStartIndex = s.length() - 1;
            int rightIndex = rightStartIndex;
            char[] chars = s.toCharArray();
            while (true) {
                char leftChar = ' ';
                while (leftIndex <= rightStartIndex && !isVowel(leftChar = chars[leftIndex])) {
                    leftIndex++;
                }
                char rightChar = ' ';
                while (rightIndex >= 0 && !isVowel(rightChar = chars[rightIndex])) {
                    rightIndex--;
                }
                if (leftIndex > rightIndex) {
                    break;
                }
                chars[leftIndex] = rightChar;
                chars[rightIndex] = leftChar;
                leftIndex++;
                rightIndex--;
            }
            return String.valueOf(chars);
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
        }
    }
}
