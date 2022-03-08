package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * Related Topics 哈希表 字符串 回溯 👍 1758 👎 0
 *
 * @author 王渔
 * @date 2022/3/8 16:59
 */
public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        List<String> res = new Solution().letterCombinations("23");
        System.out.println(Arrays.toString(res.toArray()));
    }

    static class Solution {

        char[][] chars = new char[][]{
                {}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};

        public List<String> letterCombinations(String digits) {
            char[] d = digits.toCharArray();
            int len = d.length;
            List<String> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            char[] path = new char[len];
            dfs(0, d, path, res);
            return res;
        }

        private void dfs(int i, char[] d, char[] path, List<String> res) {
            if (i == path.length) {
                res.add(new String(path));
                return;
            }
            char[] str = chars[d[i] - 48];
            for (int j = 0; j < str.length; j++) {
                path[i] = str[j];
                dfs(i + 1, d, path, res);
            }
        }
    }
}
