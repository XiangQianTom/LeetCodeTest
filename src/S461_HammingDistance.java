public class S461_HammingDistance {
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：0 ≤ x, y < 231.
     * 示例:输入: x = 1, y = 4  输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * **     ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hamming-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(4, 14));
        System.out.println(solution.hammingDistance(1, 4));
        System.out.println(solution.hammingDistance(3, 19));
    }

    static class Solution {
        public int hammingDistance1(int x, int y) {
            String xStr = Integer.toBinaryString(x);
            String yStr = Integer.toBinaryString(y);
            String longerStr;
            String shortStr;
            if (xStr.length() > yStr.length()) {
                longerStr = xStr;
                shortStr = yStr;
            } else {
                longerStr = yStr;
                shortStr = xStr;
            }
            int distance = 0;
            int shortLength = shortStr.length();
            int longerLength = longerStr.length();
            for (int i = 1; i <= shortLength; i++) {
                if (longerStr.charAt(longerLength - i) != shortStr.charAt(shortLength - i)) {
                    distance++;
                }
            }
            for (int i = shortLength + 1; i <= longerLength; i++) {
                if (longerStr.charAt(longerLength - i) != '0') {
                    distance++;
                }
            }
            return distance;
        }

        public int hammingDistance(int x, int y) {
            String xStr = Integer.toBinaryString(x);
            String yStr = Integer.toBinaryString(y);
            int xLen = xStr.length();
            int yLen = yStr.length();
            int length = Math.max(xLen, yLen);
            int distance = 0;
            for (int i = 1; i <= length; i++) {
                if (getChar(xStr, xLen, i) != getChar(yStr, yLen, i)) {
                    distance++;
                }
            }
            return distance;
        }

        private char getChar(String str, int len, int i) {
            try {
                return str.charAt(len - i);
            } catch (Exception e) {
            }
            return '0';
        }
    }
}