package com.company.leetcode;

import com.company.utils.Utils;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * <p>
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * Related Topics 数组 哈希表 排序 👍 674 👎 0
 *
 * @author 王渔
 * @date 2022/3/26 21:31
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10000; i++) {
            int[] ints = Utils.randomIntegerArray((int) (Math.random() * 10000 + 1), 0, 10000);
            if (solution.containsDuplicate(ints) != solution.containsDuplicate1(ints)) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

    static class Solution {
        /**
         * 重复数可能有两次以上，若有重复数则返回true，否则返回false
         */
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsDuplicate1(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int num;

            for (int i = 0; i < nums.length; i++) {
                num = nums[i];
                //最大值跳过
                if (num > max) {
                    max = num;
                    continue;
                }
                //最小值跳过
                if (num < min) {
                    min = num;
                    continue;
                }
                //0到i之间重复
                for (int j = 0; j < i; j++) {
                    if (nums[j] == num) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
