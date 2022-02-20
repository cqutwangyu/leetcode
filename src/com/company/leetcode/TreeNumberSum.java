package com.company.leetcode;

import com.company.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * 复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * Related Topics 数组 双指针 排序 👍 4328 👎 0
 *
 * @author 王渔
 * @date 2022/2/20 21:54
 */
public class TreeNumberSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Utils.print(lists);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length <= 2) return ans;

            Arrays.sort(nums); // O(nlogn)

            for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
                //先取第一个数，因为需要和为0，且数组做了排序，所以第一个数只取负数
                if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复解的情况
                // 将问题转化为2数之和
                int target = -nums[i];
                // 双指针查找
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    // 找到一种组合
                    if (nums[left] + nums[right] == target) {
                        //添加结果集
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        // 先排除当前已经添加的left和right值
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {  // nums[left] + nums[right] > target
                        right--;
                    }
                }
            }
            return ans;
        }
    }
}
