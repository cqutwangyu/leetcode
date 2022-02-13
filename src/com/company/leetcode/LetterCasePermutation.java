package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 784.字母大小写全排列<p>
 * Given a string s, you can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in
 * any order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and
 * digits.
 * <p>
 * Related Topics 位运算 字符串 回溯 👍 355 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 16:41
 */
public class LetterCasePermutation {

    class Solution {
        /**
         * 记录所有组合
         */
        private List<String> answer = new ArrayList<>();

        /**
         * 排列顺序不变，字母的大小写可以改变，求出所有可以组合成的字符串
         */
        public List<String> letterCasePermutation(String s) {
            // 顺序不变,直接转数组
            char[] chars = s.toCharArray();
            // 从下标0开始处理
            dfs(chars, 0);
            return answer;
        }

        private void dfs(char[] chars, int begin) {
            answer.add(new String(chars));
            // 遍历chars,改变chars[i]的大小写，深度优先组成不同的字符串
            for (int i = begin; i < chars.length; i++) {
                // 当字符不是数字时
                if (!Character.isDigit(chars[i])) {
                    // 利用^32做大小写转换
                    chars[i] ^= 32;
                    // 从i+1进行递归
                    dfs(chars, i + 1);
                    chars[i] ^= 32;
                }
            }
        }
    }
}
