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
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            //求斐波那契数列 n[i]=n[i-1]+n[i-2]
            int[] dp = new int[3];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                int sum = dp[1] + dp[2];
                dp[1] = dp[2];
                dp[2] = sum;
            }
            return dp[2];
        }
    }
}
