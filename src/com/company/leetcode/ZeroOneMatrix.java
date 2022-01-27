package com.company.leetcode;

import java.util.Arrays;

/**
 * 542.01矩阵
 * <p>
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 示例 2：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10⁴
 * 1 <= m * n <= 10⁴
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0
 * <p>
 * Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 588 👎 0
 *
 * @author 王渔
 * @date 2022/1/27 22:00
 */
public class ZeroOneMatrix {

    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; ++i) {
                Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            }
            // 如果 (i, j) 的元素为 0，那么距离为 0
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        dist[i][j] = 0;
                    }
                }
            }
            // 水平向右
            for (int i = 0; i < m; ++i) {
                // 竖直向下
                for (int j = 0; j < n; ++j) {
                    if (i - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
            // 水平向左
            for (int i = m - 1; i >= 0; --i) {
                // 竖直向下
                for (int j = 0; j < n; ++j) {
                    if (i + 1 < m) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
            // 水平向右
            for (int i = 0; i < m; ++i) {
                // 竖直向上
                for (int j = n - 1; j >= 0; --j) {
                    if (i - 1 >= 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            // 水平向左
            for (int i = m - 1; i >= 0; --i) {
                // 竖直向上
                for (int j = n - 1; j >= 0; --j) {
                    if (i + 1 < m) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
            return dist;
        }
    }

}
