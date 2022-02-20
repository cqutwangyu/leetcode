package com.company.leetcode;

/**
 * 162.寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * Related Topics 数组 二分查找 👍 715 👎 0
 *
 * @author 王渔
 * @date 2022/2/19 23:39
 */
public class FindPeakElement {
    class Solution {

        public int findPeakElement(int[] nums) {
            // 核心：nums[-1] = nums[n] = -∞ 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
            // 核心：nums[i] != nums[i+1] 相邻两个数一定不相等
            //根据上述结论，我们就可以使用二分查找找到峰值
            //查找时，左指针 l，右指针 r，保持左右顺序为循环条件
            int left = 0, right = nums.length - 1;
            while (left < right) {
                //根据左右指针计算中间位置 m
                int mid = left + (right - left) / 2;
                // 并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，r = m，
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    // 如果 m + 1 较大，则右侧存在峰值，l = m + 1
                    left = mid + 1;
                }
            }
            return left;
        }

        public int findPeakElement1(int[] nums) {
            // 峰值约等于最大值
            // 1 <= nums.length <= 1000 O(n) 不会超时
            int idx = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > nums[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
    }
}
