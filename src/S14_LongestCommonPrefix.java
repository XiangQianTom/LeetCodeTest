import java.util.HashMap;
import java.util.Map;

public class S14_LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog"}));
    }

    static class Solution {
        public String longestCommonPrefix1(String[] strs) {
            if (isEmpty(strs)) return "";
            char[] firstStr = strs[0].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < firstStr.length; i++) {
                char lastChar = firstStr[i];
                for (int j = 1; j < strs.length; j++) {
                    try {
                        if (lastChar != strs[j].charAt(i)) {
                            return sb.toString();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return sb.toString();
                    }
                }
                sb.append(lastChar);
            }
            return sb.toString();
        }

        public String longestCommonPrefix2(String[] strs) {
            if (isEmpty(strs)) return "";
            char[] firstStr = strs[0].toCharArray();
            StringBuilder sb = new StringBuilder();
            int minLength = getMinLength(strs);
            for (int i = 0; i < minLength; i++) {
                char lastChar = firstStr[i];
                for (int j = 1; j < strs.length; j++) {
                    if (lastChar != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(lastChar);
            }
            return sb.toString();
        }

        public String longestCommonPrefix(String[] strs) {
            if (isEmpty(strs)) return "";
            String common = strs[0];
            for (int i = 1; i < strs.length; i++) {
                common = getCommon(common, strs[i]);
            }
            return common;
        }

        private String getCommon(String common, String currentStr) {
            int minLength = Math.min(common.length(), currentStr.length());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < minLength; j++) {
                char c = common.charAt(j);
                if (c == currentStr.charAt(j)) {
                    sb.append(c);
                } else {
                    break;
                }
            }
            common = sb.toString();
            return common;
        }

        private boolean isEmpty(String[] strs) {
            if (null == strs || strs.length <= 0) {
                return true;
            }
            return false;
        }

        private int getMinLength(String[] strs) {
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length; i++) {
                minLength = Math.min(minLength, strs[i].length());
            }
            return minLength;
        }
    }
}
