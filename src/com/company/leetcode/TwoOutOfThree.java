package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032. 至少在两个数组中出现的值
 * <p>
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 与这三个数组都不同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数
 * 组中的元素可以按 任意 顺序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 * <p>
 * Related Topics 数组 哈希表 👍 14 👎 0
 *
 * @author 王渔
 * @date 2022/3/31 21:17
 */
public class TwoOutOfThree {
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[][] map = new int[3][101];
            List<Integer> answer = new ArrayList<>();
            for (int i : nums1) {
                ++map[0][i];
            }
            for (int i : nums2) {
                ++map[1][i];
            }
            for (int i : nums3) {
                ++map[2][i];
            }
            for (int i = 1; i < 101; i++) {
                int count = map[0][i] > 0 ? 1 : 0;
                count += map[1][i] > 0 ? 1 : 0;
                count += map[2][i] > 0 ? 1 : 0;
                if (count > 1) {
                    answer.add(i);
                }
            }
            return answer;
        }
    }
}
