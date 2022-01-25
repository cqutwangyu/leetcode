package com.company.leetcode;

import java.util.Arrays;

/**
 * 4.寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10⁶ <= nums1[i], nums2[i] <= 10⁶
 * <p>
 * Related Topics 数组 二分查找 分治 👍 4908 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 23:06
 */
public class MedianOfTwoSortedArrays {
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            //先合并数组
            int[] tempArr = new int[n1 + n2];
            int n3 = tempArr.length;
            for (int i = 0; i < n3; i++) {
                if (i < n1) {
                    //添加数组1
                    tempArr[i] = nums1[i];
                } else {
                    //添加数组2
                    tempArr[i] = nums2[i - n1];
                }
            }
            //合并后排序
            Arrays.sort(tempArr);
            int median = n3 / 2;
            //奇数则只有一个中位数，偶数则是两个中位数之和/2
            double i = n3 % 2 == 1 ? tempArr[n3 / 2] : (tempArr[median] + tempArr[median - 1]) / 2.0;
            return i;
        }
    }
}
