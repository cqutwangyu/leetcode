package com.company.leetcode;

/**
 * 567.字符串的排列
 * <p>
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
 *
 * @author 王渔
 * @date 2022/1/25 22:52
 */
public class PermutationInString {

    class Solution {
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
    }
}
