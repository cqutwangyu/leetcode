package com.company.leetcode;

/**
 * 33.搜索旋转排序数组<p>
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
 * , nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
 * example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
 * ,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -10⁴ <= nums[i] <= 10⁴
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10⁴ <= target <= 10⁴
 * <p>
 * Related Topics 数组 二分查找 👍 1837 👎 0
 *
 * @author 王渔
 * @date 2022/2/16 21:26
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            //找到最小数，即可将数组分成两个升序数组
            int min = 0, len = nums.length - 1;
            for (int i = 0; i <= len; i++) {
                min = nums[i] < nums[min] ? i : min;
            }
            //分别搜索左右两个半区
            int i = searchPartition(nums, 0, min, target);
            return i != -1 ? i : searchPartition(nums, min, len, target);
        }

        private int searchPartition(int[] nums, int start, int end, int target) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int num = nums[mid];
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    end = mid - 1;
                } else if (num < target) {
                    start = mid + 1;
                }
            }
            return -1;
        }

        public int search1(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) return mid;
                if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[r] >= target && nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return nums[l] == target ? l : -1;
        }
    }
}
