package com.company.leetcode;

/**
 * 1608. 特殊数组的特征值
 * <p>
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而
 * x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的
 * 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * 示例 3：
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * <p>
 * 示例 4：
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * Related Topics 数组 二分查找 排序 👍 39 👎 0
 *
 * @author 王渔
 * @date 2022/3/29 21:29
 */
public class SpecialArrayWithXElementsGreaterThanEqualX {
    class Solution {
        public int specialArray(int[] nums) {
            for (int i = 0; i <= nums.length; i++) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    count += nums[j] >= i ? 1 : 0;
                }
                if (count == i) {
                    return i;
                }
            }
            return -1;
        }

        public int specialArray1(int[] nums) {
            //只有0~1000的数
            int[] map = new int[1001];
            //找最大值
            int max = Integer.MIN_VALUE;
            //统计数的个数
            for (int num : nums) {
                map[num]++;
                max = Math.max(max, num);
            }
            //求出特征值x
            int sum = 0;
            //从最大值开始找（x个数大于等于x，则x为特征值）
            for (int i = max; i >= 1; i--) {
                if (map[i] > 0) sum += map[i];
                if (sum == i) return i;
            }
            return -1;
        }
    }
}
