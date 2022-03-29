package com.company.leetcode;

/**
 * 540. 有序数组中的单一元素
 * <p>
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁵
 * <p>
 * Related Topics 数组 二分查找 👍 491 👎 0
 *
 * @author 王渔
 * @date 2022/3/29 21:24
 */
public class SingleElementSortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int answer = 0;
            for (int i : nums) {
                answer ^= i;
            }
            return answer;
        }
    }
}
