import java.util.ArrayList;
import java.util.List;

public class S22_GenerateParenthesis {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        printList(solution.generateParenthesis(3));
        printList(solution.generateParenthesis(1));
    }

    private static void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str + ",");
        }
        System.out.println("----" + list.size());
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            dfs(list, n, n, "");
            return list;
        }

        private void dfs(List<String> list, int left, int right, String curStr) {
            if (left == 0 && right == 0) {
                list.add(curStr);
                return;
            }
            if (left > 0) {
                dfs(list, left - 1, right, curStr + "(");
            }
            if (right > left) {
                dfs(list, left, right - 1, curStr + ")");
            }
        }
    }
}
