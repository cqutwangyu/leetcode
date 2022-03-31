package com.company.leetcode;

/**
 * 1732. 找到最高海拔
 * <p>
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的
 * 海拔 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * <p>
 * Related Topics 数组 前缀和 👍 16 👎 0
 *
 * @author 王渔
 * @date 2022/3/30 21:41
 */
public class FindTheHighestAltitude {
    class Solution {
        public int largestAltitude(int[] gain) {
            //找最大值
            int max = Math.max(0, gain[0]);
            //下标1开始求前缀和
            for (int i = 1; i < gain.length; i++) {
                gain[i] += gain[i - 1];
                max = Math.max(gain[i], max);
            }
            return max;
        }
    }
}