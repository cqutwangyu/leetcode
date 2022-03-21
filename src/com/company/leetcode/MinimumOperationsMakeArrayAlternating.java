package com.company.leetcode;

/**
 * 2170. 使数组变成交替数组的最少操作数
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
 * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
 * <p>
 * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
 * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
 * <p>
 * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
 * 返回使数组变成交替数组的 最少操作数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,3,2,4,3]
 * 输出：3
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
 * 在这种情况下，操作数为 3 。
 * 可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,2,2]
 * 输出：2
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
 * 在这种情况下，操作数为 2 。
 * 注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 * <p>
 * Related Topics 贪心 数组 哈希表 计数 👍 24 👎 0
 *
 * @author 王渔
 * @date 2022/3/21 15:07
 */
public class MinimumOperationsMakeArrayAlternating {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 2, 3, 2, 1}));
    }

    static class Solution {
        /**
         * (1) 每个数都可以经过一次修改（注意：不是加一或者减一），所以每个数最多只需要修改一次。
         * (2) 所有下标为奇数的数需要改成一样的；所有下标为偶数的数也需要改成一样的。
         * (3) 所以，我们只需要统计所有下标为奇数的数里面频率最高的找出来，然后把其它数改成和它一样；下标为偶数的也同样处理。
         * (4) 最后统计两者之和。
         * (5) 统计一堆数里面频率最高的数，可以用哈希表实现。
         * (6) 但是，相邻的数又不能相等，所以当找出来的奇数和偶数下标对应的频率出现最高的数是相等的情况，我们需要让 奇数下标 的数选择次大的数，或者让偶数下标的数选择次大的数。
         * 原文链接：https://blog.csdn.net/WhereIsHeroFrom/article/details/123626018
         *
         * @param nums
         * @return
         */
        public int minimumOperations(int[] nums) {
            //最大值是10的5次方
            //用二维数组统计每个数字出现的次数，0层为偶数下标，1层为奇数下标 hash[index&1]
            int[][] hash = new int[2][100005];
            int i, j, ans = Integer.MAX_VALUE;
            //最大出现次数的数下标
            int[] maxIdx = new int[2];
            //次大出现次数的数下标
            int[] secMaxIdx = new int[2];
            //次数
            int[] count = new int[2];
            //统计出每个数在奇偶下标出现的次数
            for (i = 0; i < nums.length; i++) {
                // 下标为奇数的放hash[1]，下标为偶数的放hash[0]
                ++hash[i & 1][nums[i]];
            }
            //找到出现次数最多的数0为偶，1为奇
            for (i = 0; i < 2; i++) {
                // maxIdx[i] 代表频率出现最高的数字的下标
                maxIdx[i] = -1;
                secMaxIdx[i] = -1;
                // 总共有多少个数
                count[i] = 0;
                for (j = 0; j <= 100000; j++) {
                    //hash[奇偶][数字]=出现的次数
                    int numCount = hash[i][j];
                    if (maxIdx[i] == -1 || numCount > hash[i][maxIdx[i]]) {
                        //有更大的，则当前最大的做为次大
                        secMaxIdx[i] = maxIdx[i];
                        //找到最大的
                        maxIdx[i] = j;
                    } else if (secMaxIdx[i] == -1 || numCount > hash[i][secMaxIdx[i]]) {
                        //找到次大的
                        secMaxIdx[i] = j;
                    }
                    //次数
                    count[i] += numCount;
                }
            }

            //求最少修改次数
            int[] a = {maxIdx[0], secMaxIdx[0]};
            int[] b = {maxIdx[1], secMaxIdx[1]};
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
                    if (a[i] != b[j]) {
                        // 偶数下标变成 a[i]
                        //偶数下标需要修改的次数
                        int aCount = count[0] - hash[0][a[i]];
                        // 奇数下标变成 b[j]
                        //奇数下标需要修改的次数
                        int bCount = count[1] - hash[1][b[j]];
                        //求最小修改次数
                        ans = Math.min(ans, aCount + bCount);
                    }
                }
            }
            return ans;
        }
    }
}
