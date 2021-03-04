public class S28_StrStr {
    /**
     * 实现strStr()函数。
     * <p>
     * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
     * <p>
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
    }

    static class Solution {

        public int strStr1(String haystack, String needle) {
            if (null == needle || needle.length() == 0)
                return 0;
            return haystack.indexOf(needle);
        }

        public int strStr2(String haystack, String needle) {
            if (null == needle || needle.length() == 0)
                return 0;
            char first = needle.charAt(0);
            int max = haystack.length() - needle.length();

            for (int i = 0; i <= max; i++) {
                while (haystack.charAt(i) != first && ++i <= max) ;
                if (i <= max) {
                    int j = i + 1;
                    int end = j + needle.length() - 1;
                    for (int k = 1;
                         j < end &&
                                 haystack.charAt(j) == needle.charAt(k);
                         j++, k++)
                        ;
                    if (j == end) {
                        return i;
                    }
                }
            }
            return -1;
        }

        //KMP算法
        public int strStr(String haystack, String needle) {
            if (null == needle || needle.length() == 0)
                return 0;
            int n1 = haystack.length(), n2 = needle.length();
            int[] next = new int[n2];
            getNext(next, needle);//计算子串中回退的位置
            int i = 0, j = 0;
            while (i < n1 && j < n2) {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];//j回退
                }
                if (j == n2) return i - n2;

            }
            return -1;
        }

        private void getNext(int[] next, String t) {
            //找到每个字符的前一个匹配位置
            int j = 0, k = -1;
            next[0] = -1;
            while (j < t.length() - 1) {
                if (k == -1 || t.charAt(j) == t.charAt(k)) {
                    k++;
                    j++;
                    next[j] = k;//如果匹配则前一个匹配位置为k,否则说明k在开头，则next[j]=0
                } else {
                    k = next[k];//k调到上一个位置重新匹配
                }
            }
        }
    }
}