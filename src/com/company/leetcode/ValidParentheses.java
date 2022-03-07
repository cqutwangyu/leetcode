package com.company.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * Related Topics 栈 字符串 👍 3043 👎 0
 *
 * @author 王渔
 * @date 2022/3/7 14:42
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = new Solution().isValid("()");
        System.out.println(valid);
    }

    static class Solution {

        public boolean myisValid(String s) {
            String p = "(){}[]";
            if (s.length() % 2 == 1) {
                return false;
            }
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            int index = 0;
            while (index < s.length()) {
                int i = p.indexOf(chars[index]);
                if (i < 0) {
                    return false;
                }
                if (i % 2 == 0) {
                    stack.push(chars[index]);
                } else {
                    if (!stack.isEmpty() && stack.peek().equals(p.charAt(i - 1))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                index++;
            }
            return stack.isEmpty();
        }

        public boolean isValid(String s) {
            char[] str = s.toCharArray();
            char[] stack = new char[str.length];
            int size = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '(') {
                    stack[size++] = ')';
                } else if (str[i] == '{') {
                    stack[size++] = '}';
                } else if (str[i] == '[') {
                    stack[size++] = ']';
                } else {
                    if (size == 0) {        // 【注意1： 如果要弹出了，栈为空，那false】
                        return false;
                    } else {
                        char popCh = stack[--size];
                        if (str[i] != popCh) {     // 【注意2】弹出之后，不匹配，false
                            return false;
                        }
                    }
                }
            }
            // 要正正好好，两两配对，那么退出时，stack == null！
            return size == 0;
        }
    }
}
