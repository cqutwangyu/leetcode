package com.company.leetcode;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * Related Topics 数组 二分查找 👍 1448 👎 0
 *
 * @author 王渔
 * @date 2022/2/14 22:14
 */
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 1 && nums[0] == target) {
                return new int[]{0, 0};
            }
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int[] answer = {-1, -1};
            if (left < right) {
                for (int i = left; i <= right; i++) {
                    if (answer[0] == -1 && nums[i] == target) {
                        answer[0] = i;
                    } else if (nums[i] == target) {
                        answer[1] = i;
                    }
                }
            }
            answer[1] = answer[1] == -1 ? answer[0] : answer[1];
            return answer;
        }
    }
}
