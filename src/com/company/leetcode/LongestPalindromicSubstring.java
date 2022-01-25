package com.company.leetcode;

/**
 * 5.最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * Related Topics 字符串 动态规划 👍 4614 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 23:07
 */
public class LongestPalindromicSubstring {
    class Solution {
        private int maxLen = 0;
        private String sub = "";

        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                //单核回文 aba abcba
                findLongestPalindrome(s, i, i);
                //双核回文 abba abccba
                findLongestPalindrome(s, i, i + 1);
            }
            return sub;
        }

        public void findLongestPalindrome(String s, int low, int high) {
            while (low >= 0 && high <= s.length() - 1) {
                //首尾相同
                if (s.charAt(low) == s.charAt(high)) {
                    //长度大于maxlen
                    if (high - low + 1 > maxLen) {
                        maxLen = high - low + 1;
                        sub = s.substring(low, high + 1);
                    }
                    //向两边扩散找当前字符为中心的最大回文子串
                    low--;
                    high++;
                } else {
                    break;
                }
            }
        }
    }
}
