package com.company.leetcode;

/**
 * 198.打家劫舍<p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
 * 被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * Related Topics 数组 动态规划 👍 1911 👎 0
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
