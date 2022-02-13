package com.company.leetcode;

/**
 * 136.只出现一次的数字<p>
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -3 * 10⁴ <= nums[i] <= 3 * 10⁴
 * Each element in the array appears twice except for one element which appears
 * only once.
 * <p>
 * Related Topics 位运算 数组 👍 2241 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 22:09
 */
public class SingleNumber {
    class Solution {
        /**
         * 交换律：a ^ b ^ c <=> a ^ c ^ b
         * <p>
         * 任何数于0异或为任何数 0 ^ n => n
         * <p>
         * 相同的数异或为0: n ^ n => 0
         * <p>
         * int[] a = [2,3,2,4,4]
         * <p>
         * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[0] ^= nums[i];
            }
            return nums[0];
        }
    }
}
