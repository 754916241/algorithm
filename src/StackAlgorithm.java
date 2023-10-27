import java.util.Stack;

public class StackAlgorithm {

    /**
     * 32. 最长有效括号
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * https://leetcode.cn/problems/longest-valid-parentheses/
     */
    public int longestValidParentheses(String s) {
        // 栈保存的是下标
        Stack<Integer> stack = new Stack<>();
        // start标记从哪里开始
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                } else {
                    start = i + 1;
                }
            }
        }

        return res;
    }
}
