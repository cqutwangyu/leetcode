package com.company.leetcode;

import java.util.List;

/**
 * 120.三角形最小路径和<p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either index i
 * or index i + 1 on the next row.
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
 * above).
 * <p>
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
 * <p>
 * Constraints:
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10⁴ <= triangle[i][j] <= 10⁴
 * <p>
 * Follow up: Could you do this using only O(n) extra space, where n is the
 * total number of rows in the triangle? Related Topics 数组 动态规划 👍 957 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 20:43
 */
public class Triangle {

    static class Solution {
        /**
         * 逆向思维，从最底下往上走，每一步都算出最小路径
         * <p>
         * [4, 0, 0, 0, 0]
         * [4, 1, 0, 0, 0]
         * [4, 1, 8, 0, 0]
         * [4, 1, 8, 3, 0]
         * <p>以上是第四层<p>
         * [7, 1, 8, 3, 0]
         * [7, 6, 8, 3, 0]
         * [7, 6, 10, 3, 0]
         * <p>以上是第三层<p>
         * [9, 6, 10, 3, 0]
         * [9, 10, 10, 3, 0]
         * <p>以上是第二层<p>
         * [11, 10, 10, 3, 0]
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size() + 1];
            //从最底层开始向上循环
            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> curList = triangle.get(i);
                //遍历这一层
                for (int j = 0; j < curList.size(); j++) {
                    // 计算当前层第j个位置的最小路径
                    // 上一层的j和j+1的最小值，加上当前层的j
                    dp[j] = Math.min(dp[j], dp[j + 1]) + curList.get(j);
                }
            }
            //因为最顶层只有一个值，所以最小路径是存在下标0
            return dp[0];
        }
    }
}
