package com.company.leetcode;

/**
 * 3.无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 6803 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 23:01
 */
public class LengthOfLongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int size = s.length();
            if (size <= 1) {
                return size;
            }

            //慢指针
            int left = 0;
            //快指针
            int right = 1;
            int max = 1;
            while (right < size) {
                boolean duplicated = false;
                //检查从左到右是否有重复
                for (int i = left; i < right; i++) {
                    //发现中间有重复时，左指针跳到i+1，因为后面还有i这个字符
                    if (s.charAt(i) == s.charAt(right)) {
                        left = i + 1;
                        duplicated = true;
                        break;
                    }
                }
                //不重复时，记录最大连续不重复子串长度
                if (!duplicated) {
                    max = Math.max(right - left + 1, max);
                }
                right++;
            }
            return max;
        }
    }
}
