package com.company.leetcode;

/**
 * 724. 寻找数组的中心下标
 * <p>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁴
 * -1000 <= nums[i] <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 1991 题相同：https://leetcode-cn.com/problems/find-the-middle-index-in-
 * array/
 * Related Topics 数组 前缀和 👍 383 👎 0
 *
 * @author 王渔
 * @date 2022/4/5 21:26
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
//        System.out.println(new Solution().pivotIndex(new int[]{2, 1, -1}));
    }

    static class Solution {
        /**
         * 若左侧无数视为0，若右侧无数视为0
         * 输入数   {1, 7, 3, 6, 5, 6}
         * 前缀和 0 {1, 8, 11, 17, 22, 28} 0
         * i左边的和等于sum[i-1];
         * i右边的和等于sum[len-1]-sum[i];
         */
        public int pivotIndex(int[] nums) {
            int[] sum = new int[nums.length];
            int len = nums.length;
            //前缀和
            for (int i = 0; i < len; i++) {
                sum[i] = nums[i];
                if (i > 0)
                    sum[i] += sum[i - 1];
            }
            /**
             * 输入值{2, 1, -1}
             * 前缀和{2, 3, 2}
             */
            if (sum[len - 1] - sum[0] == 0) {
                return 0;
            }
            for (int i = 1; i < len; i++) {
                if (sum[i - 1] == sum[len - 1] - sum[i]) {
                    return i;
                }
            }
            return -1;
        }

        public int pivotIndex1(int[] nums) {
            int len = nums.length - 1;
            int sum = 0;
            for (int i = len; i >= 0; i--) {
                sum += nums[i];
            }
            if (sum - nums[0] == 0)
                return 0;
            int sum_right = 0;
            int j = 0;
            sum -= nums[j];
            while (j <= len - 1) {
                sum -= nums[j + 1];
                sum_right += nums[j];
                if (sum == sum_right)
                    return j + 1;
                j++;
            }
            return -1;
        }
    }
}
