package com.company.leetcode;

/**
 * 1588. 所有奇数长度子数组的和
 * <p>
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * Related Topics 数组 数学 前缀和 👍 167 👎 0
 *
 * @author 王渔
 * @date 2022/3/30 21:25
 */
public class SumOfAllOddLengthSubarrays {
    class Solution {
        /**
         * 暴力解法
         */
        public int sumOddLengthSubarrays(int[] arr) {
            int sum = 0, len = arr.length;
            //遍历子数组
            for (int start = 0; start < len; start++) {
                //长度始终为奇数
                for (int length = 1; start + length <= len; length += 2) {
                    //计算子数组的end下标
                    int end = start + length - 1;
                    //从start到end求和
                    for (int i = start; i <= end; i++) {
                        sum += arr[i];
                    }
                }
            }
            return sum;
        }

        /**
         * 前缀和
         */
        public int sumOddLengthSubarrays1(int[] arr) {
            int n = arr.length;
            int[] prefixSums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSums[i + 1] = prefixSums[i] + arr[i];
            }
            int sum = 0;
            for (int start = 0; start < n; start++) {
                for (int length = 1; start + length <= n; length += 2) {
                    int end = start + length - 1;
                    sum += prefixSums[end + 1] - prefixSums[start];
                }
            }
            return sum;
        }

    }
}
