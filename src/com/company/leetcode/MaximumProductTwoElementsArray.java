package com.company.leetcode;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 * <p>
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
 * 3*4 = 12 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,7]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * <p>
 * Related Topics 数组 排序 堆（优先队列） 👍 30 👎 0
 *
 * @author 王渔
 * @date 2022/3/16 15:03
 */
public class MaximumProductTwoElementsArray {
    class Solution {
        /**
         * 由于nums中的数字全是正数，所以问题转变为找出最大的两个数相乘的结果。
         */
        public int maxProduct(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        }
    }
}
