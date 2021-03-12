public class S434_CountSegments {
    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * 示例:输入: "Hello, my name is John"  输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));//5
        System.out.println(solution.countSegments("aa bb"));//2
        System.out.println(solution.countSegments("ab ,"));//2
        System.out.println(solution.countSegments("ad , ,"));//3
        System.out.println(solution.countSegments(" "));//0
        System.out.println(solution.countSegments("    "));//0
        System.out.println(solution.countSegments(","));//1
        System.out.println(solution.countSegments(" , "));//1
        System.out.println(solution.countSegments(", , , ,        a, eaefa"));//6
        System.out.println(solution.countSegments(",     ,"));//2
    }

    static class Solution {
        public int countSegments1(String s) {
            int count = 0;
            boolean isWord = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    isWord = true;
                } else if (isWord) {
                    count++;
                    isWord = false;
                }
            }
            return count;
        }

        public int countSegments(String s) {
            String trimmed = s.trim();
            if (trimmed.equals("")) {
                return 0;
            }
            return trimmed.split("\\s+").length;// '\\s'代表空格
        }
    }
}