package com.company.leetcode;

/**
 * 28. 实现stStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
 * 果不存在，则返回 -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 10⁴
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * Related Topics 双指针 字符串 字符串匹配 👍 1289 👎 0
 *
 * @author 王渔
 * @date 2022/3/7 21:10
 */
public class ImplementStrStr {
    public static void main(String[] args) {
//        System.out.println(new Solution().strStr("hello", "ll"));
//        System.out.println(new Solution().strStr("abc", "c"));
//        System.out.println(new Solution().strStr("mississippi", "issi"));
//        System.out.println(new Solution().strStr("mississippi", "issip"));
//        System.out.println(new Solution().strStr("mississippi", "issip"));
        System.out.println(new Solution().strStr("aaaaa", "aa"));
    }

    static class Solution {

        // KMP 算法
        // ss: 原串(string)  pp: 匹配串(pattern)
        public int strStr(String ss, String pp) {
            if (pp.isEmpty()) return 0;

            // 分别读取原串和匹配串的长度
            int n = ss.length(), m = pp.length();
            // 原串和匹配串前面都加空格，使其下标从 1 开始
            ss = " " + ss;
            pp = " " + pp;

            char[] s = ss.toCharArray();
            char[] p = pp.toCharArray();

            // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
            int[] next = new int[m + 1];
            // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
            for (int i = 2, j = 0; i <= m; i++) {
                // 匹配不成功的话，j = next(j)
                while (j > 0 && p[i] != p[j + 1]) j = next[j];
                // 匹配成功的话，先让 j++
                if (p[i] == p[j + 1]) j++;
                // 更新 next[i]，结束本次循环，i++
                next[i] = j;
            }

            // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
            for (int i = 1, j = 0; i <= n; i++) {
                // 匹配不成功 j = next(j)
                while (j > 0 && s[i] != p[j + 1]) j = next[j];
                // 匹配成功的话，先让 j++，结束本次循环后 i++
                if (s[i] == p[j + 1]) j++;
                // 整一段匹配成功，直接返回下标
                if (j == m) return i - m;
            }

            return -1;
        }

        public int strStr0(String ss, String pp) {
            int n = ss.length(), m = pp.length();
            char[] s = ss.toCharArray(), p = pp.toCharArray();
            // 枚举原串的「发起点」
            for (int i = 0; i <= n - m; i++) {
                // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
                int a = i, b = 0;
                while (b < m && s[a] == p[b]) {
                    a++;
                    b++;
                }
                // 如果能够完全匹配，返回原串的「发起点」下标
                if (b == m) return i;
            }
            return -1;
        }

        public int strStr1(String haystack, String needle) {
            if (haystack.length() < needle.length()) {
                return -1;
            }
            if (haystack.equals(needle) || needle.isEmpty()) {
                return 0;
            }
            int start = 0, answer = -1, s2 = 0;
            while (start <= haystack.length() - needle.length()) {
                s2 = 0;
                int tmp = start;
                while (haystack.charAt(start++) == needle.charAt(s2++)) {
                    if (s2 == needle.length()) {
                        return tmp;
                    }
                }
                start = tmp + 1;
            }
            return -1;
        }
    }
}
