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
            // 二分查找
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
            //没找到直接返回-1
            int[] answer = {-1, -1};
            //找到之后 target一定在left和right之间
            if (left <= right) {
                for (int i = left; i <= right; i++) {
                    if (answer[0] == -1 && nums[i] == target) {
                        //第一个target的位置
                        answer[0] = i;
                        answer[1] = i;
                    } else if (nums[i] == target) {
                        //最后一个target的位置
                        answer[1] = i;
                    }
                }
            }
            return answer;
        }

        private int left(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    // 缩小右边界，在左半部分继续查找
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }

            if (left == nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        private int right(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            // 循环结束的条件是left==right
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    // 继续在右半部分查找
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }

            // right == 0 一是数组为空，即{}
            // 二是目标值target小于数组中所有元素
            if (right == 0 || nums[right - 1] != target) {
                return -1;
            }
            // 最后返回right-1，是因为循环结束的条件是left==right
            // 而left=mid+1，mid所在位置即为目标值所在位置
            // 因此mid=left-1，即mid=right-1
            return right - 1;
        }

    }
}
