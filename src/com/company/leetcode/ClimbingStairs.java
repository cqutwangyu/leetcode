package com.company.leetcode;

/**
 * 70.爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * 1 <= n <= 45
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 2150 👎 0
 *
 * @author 王渔
 * @date 2022/1/30 20:27
 */
public class ClimbingStairs {
    class Solution {
        /**
         斐波那契数列 a1,a2,a3 保持a3=a2+a1的规律
         */
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            //a1=1,a2=2
            int[] dp = {1,2};
            //上来就求第一个a3
            for (int i = 3; i <= n; i++) {
                //a3=a1+a2
                int sum = dp[0] + dp[1];
                //a2设为a1
                dp[0] = dp[1];
                //a3设为a2
                dp[1] = sum;
            }
            //最终的a2就是跳到n的方法数
            return dp[1];
        }
    }
}
