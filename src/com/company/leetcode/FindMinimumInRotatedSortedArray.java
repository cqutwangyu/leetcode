package com.company.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
 * 化后可能得到：
 * <p>
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
 * ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * <p>
 * Related Topics 数组 二分查找 👍 668 👎 0
 *
 * @author 王渔
 * @date 2022/2/17 22:53
 */
public class FindMinimumInRotatedSortedArray {
    class Solution {


        public int findMin(int[] nums) {
            //1 <= n <= 5000 直接暴力解
            int min = nums[0];
            for (int i = nums.length / 2; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }

        public int findMin1(int[] nums) {
            //最优解，要么0是最小，要么你遇到的第一个递减数是最小
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] >= nums[i + 1]) {
                    return nums[i + 1];
                }
            }
            return nums[0];
        }

        public int findMin2(int[] nums) {
            //本题考点正解二分查找
            int l = 0, r = nums.length - 1, mid;
            while (l < r) {
                mid = l + ((r - l) >> 1);
                //mid小于right,说明是升序
                if (nums[mid] < nums[r]) {
                    r = mid;//r永远不会小于l
                } else {
                    //否则存在陡然变小的情况，l往右走
                    l = mid + 1;//l可能等于r
                }
            }
            //结束条件是l==r
            return nums[l];
        }
    }
}
