package com.company.leetcode;

/**
 * 53. 最大子数组和
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * Related Topics 数组 分治 动态规划 👍 4483 👎 0
 *
 * @author 王渔
 * @date 2022/3/9 16:52
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static class Solution {

        /**
         * 动态规划
         */
        public int maxSubArray(int[] nums) {
            int len = nums.length, max = nums[0];
            for (int i = 1; i < len; i++) {
                //当前面一个数大于0时，当前数等于前一个数加当前数，否则当前数不变
                if (nums[i - 1] > 0) {
                    nums[i] += nums[i - 1];
                }
                //记录最大值
                max = Math.max(nums[i], max);
            }
            return max;
        }

        /**
         * 贪心
         */
        public int maxSubArray1(int[] nums) {
            int curSum = 0, max = nums[0];
            for (int curValue : nums) {
                //curSum小于curValue时，则丢弃前面的和
                curSum = Math.max(curSum + curValue, curValue);
                //记录最大值
                max = Math.max(max, curSum);
            }
            return max;
        }
    }
}
