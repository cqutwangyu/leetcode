package com.company.leetcode;

/**
 * 485. 最大连续 1 的个数
 * <p>
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1.
 * <p>
 * Related Topics 数组 👍 304 👎 0
 *
 * @author 王渔
 * @date 2022/3/16 15:11
 */
public class MaxConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            //统计最大连续1的个数
            int count = 0, max = 0;
            for (int i = 0; i < nums.length; i++) {
                //不连续则清零
                count = nums[i] == 0 ? 0 : count + 1;
                //找最大连续个数
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
