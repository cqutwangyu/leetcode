package com.company.leetcode;

import java.util.*;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 514 👎 0
 *
 * @author 王渔
 * @date 2022/3/29 21:41
 */
public class IntersectionTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] hashtab = new int[1001];  //hashtab
            int[] ans = new int[nums2.length > nums1.length ? nums1.length : nums2.length];
            int cnt = 0;

            //记录nums1中的数
            for (int i : nums1)
                hashtab[i]++;

            //在nums2中找nums1中出现过的数
            for (int i : nums2) {
                //nums1中有
                if (hashtab[i] > 0) {
                    //避免重复
                    hashtab[i] = 0;
                    //记作交集
                    ans[cnt++] = i;
                }
            }

            //返回交集数组有效长度
            int[] ret = new int[cnt];
            for (int i = 0; i < cnt; i++)
                ret[i] = ans[i];

            return ret;
        }

        public int[] intersection1(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> answer = new HashSet<>();
            for (int i : nums1) {
                list.add(i);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (list.contains(nums2[i])) {
                    answer.add(nums2[i]);
                }
            }
            int[] ints = new int[answer.size()];
            Object[] objects = answer.toArray();
            for (int i = 0; i < objects.length; i++) {
                ints[i] = (int) objects[i];
            }
            return ints;
        }

    }
}
