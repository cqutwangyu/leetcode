package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 targe
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * 只会存在一个有效答案
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
 * Related Topics 数组 哈希表 👍 13215 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 22:54
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] twoSum = new int[]{0, 1};
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(target - num)) {
                    twoSum[0] = i;
                    twoSum[1] = map.get(target - num);
                    break;
                }
                map.put(num, i);
            }
            return twoSum;
        }
    }
}
