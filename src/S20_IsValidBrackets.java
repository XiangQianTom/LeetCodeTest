import java.util.Objects;
import java.util.Stack;

public class S20_IsValidBrackets {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(("));//false
        System.out.println(solution.isValid("(([]){})"));//true
        System.out.println(solution.isValid("())"));//false
        System.out.println(solution.isValid("()[]{}"));//ture
        System.out.println(solution.isValid("{()[]}"));//true
        System.out.println(solution.isValid("{}()[]{}"));//true
        System.out.println(solution.isValid("{()}"));//true
        System.out.println(solution.isValid("(]"));//false
        System.out.println(solution.isValid("([)]"));//false
    }

    static class Solution {
        public boolean isValid1(String s) {
            String target;
            while (s.contains(target = "()")
                    || s.contains(target = "[]")
                    || s.contains(target = "{}")) {
                s = s.replace(target, "");
            }
            return Objects.equals(s, "");
        }

        public boolean isValid2(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '[') stack.push(']');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || c != stack.pop()) return false;
            }
            return stack.isEmpty();
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }

        private boolean isValid(char leftChar, char rightChar) {
            return leftChar == '(' && rightChar == ')'
                    || leftChar == '[' && rightChar == ']'
                    || leftChar == '{' && rightChar == '}';
        }
    }
}
