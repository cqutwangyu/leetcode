package com.company.leetcode;

/**
 * 198.打家劫舍<p>
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
 * (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * Related Topics 数组 动态规划 👍 1879 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 20:25
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
    }

    static class Solution {
        /**
         * 不能偷连续的两家，求出一晚最多能偷多少钱
         * 当偷到第i家时，能偷两种方法，偷i-2的加上i，或者偷i-1的且不偷i
         * 前两家能偷到的最大值，可以直接算出
         * 第三家能偷到的最大值需要参考前两家的结果，后面第四家的参考第三家的结果
         * 依次递推，每次确保偷出最大值，每次只有两种偷法
         */
        public int rob(int[] nums) {
            int len = nums.length;

            if (len == 1) return nums[0];
            if (len == 2) return Math.max(nums[0], nums[1]);
            //前两家能偷到的最大值
            int[] dp = {nums[0], Math.max(nums[0], nums[1])};
            //从第三家开始，前两家已经算好了
            for (int i = 2; i < len; i++) {
                int max = Math.max(dp[0] + nums[i], dp[1]);
                //只需要保留两家的信息
                dp[0] = dp[1];
                dp[1] = max;
            }

            //返回偷到最后一家最多能偷到的钱数
            return dp[1];
        }
    }

}
