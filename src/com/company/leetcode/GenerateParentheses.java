package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 * <p>
 * Related Topics 字符串 动态规划 回溯 👍 2427 👎 0
 *
 * @author 王渔
 * @date 2022/3/8 21:00
 */
public class GenerateParentheses {
    public static void main(String[] args) {

    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
            if (sb.length() == max * 2) {
                ans.add(sb.toString());
                return;
            }
            if (open < max) {
                sb.append('(');
                backtrack(ans, sb, open + 1, close, max);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(')');
                backtrack(ans, sb, open, close + 1, max);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public List<String> generateParenthesis1(int n) {
            List<String> list = new ArrayList<>();
            dfs(n, n, "", list);
            return list;
        }

        private void dfs(int left, int right, String s, List<String> r) {
            if (left > right || left < 0 || right < 0) {
                return;
            }
            if (left == 0 && right == 0) {
                r.add(s);
                return;
            }
            dfs(left - 1, right, s + "(", r);
            dfs(left, right - 1, s + ")", r);
        }
    }
}
