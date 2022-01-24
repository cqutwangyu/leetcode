package com.company;

import java.util.Arrays;

/**
 * todo desc
 *
 * @author 王渔
 * @date 2022/1/23 22:21
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }


    /**
     * [567]字符串的排列
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     * 示例 1：
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * <p>
     * 示例 2：
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * <p>
     * 提示：
     * 1 <= s1.length, s2.length <= 10⁴
     * s1 和 s2 仅包含小写字母
     * <p>
     * Related Topics 哈希表 双指针 字符串 滑动窗口 👍 548 👎 0
     */
    public boolean checkInclusion(String s1, String s2) {
        //转char数组、记录长度
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int s1Len = s1.length(), s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        /**
         * 思路：在s2中寻找s1的字母排列，不关心顺序，但关心出现次数和连续性。
         * 通过滑动窗口
         * 小写字母'a'~'z'=97~122,大写字母'A'~'Z'=41~90
         * 'a'-97=0,'z'-97=25,所以用长度26的数组来存储
         */
        //用于记录某个字母出现的次数
        int[] pFreq = new int[26];
        int[] winFreq = new int[26];
        //偏移量97
        char offset = 'a';

        //26个字母减去偏移量'a',使字母的值转为0~25的下标
        for (int i = 0; i < s1Len; i++) {
            //记录s1中出现的各个字母的次数
            pFreq[c1[i] - offset]++;
        }

        //s1中出现的不同字母个数
        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            //出现了
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        //滑动窗口的变量
        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字母个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < s2Len) {

            if (pFreq[c2[right] - offset] > 0) {
                //右边界上的字母在s1中存在
                winFreq[c2[right] - offset]++;
                //右边界上的字母出现次数与s1中出现的次数相同
                if (winFreq[c2[right] - offset] == pFreq[c2[right] - offset]) {
                    winCount++;
                }
            }
            //外层循环：右边界向右移动
            right++;

            //当前窗口中出现的不同字母个数与s1中的相同
            while (pCount == winCount) {
                //且窗口的长度和s1相同，相同字母的出现具有连续性
                if (right - left == s1Len) {
                    //找到了
                    return true;
                }
                //没找到
                if (pFreq[c2[left] - offset] > 0) {
                    //左边界准备右移，窗口将丢弃一个字母，将丢弃的字母出现次数同步更新。
                    winFreq[c2[left] - offset]--;
                    //丢弃一个字母后，这个字母的出现次数也变少了，则不能与s1中的出现次数相同
                    if (winFreq[c2[left] - offset] < pFreq[c2[left] - offset]) {
                        //减少出现次数相同的字母个数
                        winCount--;
                    }
                }
                //内层让左边界向右移动
                left++;
            }
        }
        //从头到尾没找到
        return false;
    }


    /**
     * [5]最长回文子串
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
     */
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

    private int maxLen = 0;
    private String sub = "";

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

    /**
     * [4]寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 示例 3：
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * <p>
     * 示例 4：
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * <p>
     * 示例 5：
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * <p>
     * 提示：
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -10⁶ <= nums1[i], nums2[i] <= 10⁶
     * <p>
     * Related Topics 数组 二分查找 分治 👍 4908 👎 0
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //先合并数组
        int[] tempArr = new int[n1 + n2];
        int n3 = tempArr.length;
        for (int i = 0; i < n3; i++) {
            if (i < n1) {
                //添加数组1
                tempArr[i] = nums1[i];
            } else {
                //添加数组2
                tempArr[i] = nums2[i - n1];
            }
        }
        //合并后排序
        Arrays.sort(tempArr);
        int median = n3 / 2;
        //奇数则只有一个中位数，偶数则是两个中位数之和/2
        double i = n3 % 2 == 1 ? tempArr[n3 / 2] : (tempArr[median] + tempArr[median - 1]) / 2.0;
        return i;
    }

    /**
     * [3]无重复字符的最长子串
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
     */
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
