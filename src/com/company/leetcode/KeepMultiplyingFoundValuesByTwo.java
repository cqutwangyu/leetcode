package com.company.leetcode;

/**
 * 2154. 将找到的值乘以 2
 * <p>
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 * 接下来，你需要按下述步骤操作：
 * <p>
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 *
 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * <p>
 * 返回 original 的 最终 值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,6,1,12], original = 3
 * 输出：24
 * 解释：
 * - 3 能在 nums 中找到。3 * 2 = 6 。
 * - 6 能在 nums 中找到。6 * 2 = 12 。
 * - 12 能在 nums 中找到。12 * 2 = 24 。
 * - 24 不能在 nums 中找到。因此，返回 24 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9], original = 4
 * 输出：4
 * 解释：
 * - 4 不能在 nums 中找到。因此，返回 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], original <= 1000
 * <p>
 * Related Topics 数组 哈希表 排序 模拟 👍 10 👎 0
 *
 * @author 王渔
 * @date 2022/3/27 11:57
 */
public class KeepMultiplyingFoundValuesByTwo {
    class Solution {
        public int findFinalValue(int[] nums, int original) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == original) {
                    return findFinalValue(nums, original * 2);
                }
            }
            return original;
        }
    }
}
