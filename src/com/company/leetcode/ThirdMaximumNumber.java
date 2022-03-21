package com.company.leetcode;

/**
 * 414. 第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * Related Topics 数组 排序 👍 348 👎 0
 *
 * @author 王渔
 * @date 2022/3/17 23:47
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int i = new Solution().thirdMax(new int[]{1, 2});
        System.out.println(i);
    }

    static class Solution {
        public int thirdMax(int[] nums) {
            //为什么实用Long？因为第三大的数可能是Integer.MIN_VALUE
            Long max = Long.MIN_VALUE, max2 = max, max3 = max;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                //重复数字的排名一样直接跳过
                if (num == max || num == max2 || num == max3) {
                    continue;
                }
                //依次递推
                if (num > max) {
                    max3 = max2;
                    max2 = max;
                    max = (long) num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = (long) num;
                } else if (num > max3) {
                    max3 = (long) num;
                }
            }
            //题意：第三大的数不存在则取前两个数中最大值
            if (max3 == Long.MIN_VALUE) {
                max3 = Math.max(max, max2);
            }
            //return int
            return max3.intValue();
        }
    }
}
