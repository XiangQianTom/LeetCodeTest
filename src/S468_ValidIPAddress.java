public class S468_ValidIPAddress {
    /**
     * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
     * <p>
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
     * <p>
     * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
     * <p>
     * 1 <= xi.length <= 4
     * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
     * 在 xi 中允许前导零。
     * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：queryIP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     * 示例 2：
     * <p>
     * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     * 示例 3：
     * <p>
     * 输入：queryIP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     * <p>
     * 作者：字节校园
     * 链接：https://leetcode.cn/leetbook/read/bytedance-c01/eiy7bt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("172.16.254.1"));//IPv4
        System.out.println(solution.validIPAddress("172.16.254.01"));//Neither
        System.out.println(solution.validIPAddress("172.16.254.1.1"));//Neither
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));//IPv6
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:1"));//IPv6
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:1.1"));//Neither
        System.out.println(solution.validIPAddress("256.256.256.256"));//Neither
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));//Neither
        System.out.println(solution.validIPAddress("1.0.1."));//Neither
        System.out.println(solution.validIPAddress("192.168..1"));//Neither
        System.out.println(solution.validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"));//Neither
        System.out.println(solution.validIPAddress("2001:.0db:85a3:0:0:8A2E:0370:1"));//IPv6
    }

    static class Solution {
        public String validIPAddress(String queryIP) {
            String[] ip4Arr = queryIP.split("\\.", -1);
            String[] ip6Arr = queryIP.split(":", -1);
            int ip4Length = ip4Arr.length;
            int ip6Length = ip6Arr.length;
            if (ip6Length == 1 && ip4Length == 4) {
                return checkIp4(ip4Arr);
            } else if (ip4Length == 1 && ip6Length == 8) {
                return checkIp6(ip6Arr);
            } else {
                return "Neither";
            }
        }

        private String checkIp4(String[] ips) {
            for (String child : ips) {
                try {
                    int num = Integer.parseInt(child);
                    if (num < 0 || num > 255 || (child.length() > 1 && child.indexOf('0') == 0)) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv4";
        }

        private String checkIp6(String[] ips) {
            for (String child : ips) {
                char[] chars = child.toCharArray();
                int length = chars.length;
                if (length > 4 || length < 1) {
                    return "Neither";
                }
                for (char c : chars) {
                    if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}
