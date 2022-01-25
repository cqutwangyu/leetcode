package com.company.leetcode;

/**
 * 695.岛屿的最大面积
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
 * 被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：<p>grid = [<p>[0,0,1,0,0,0,0,1,0,0,0,0,0],<p>[0,0,0,0,0,0,0,1,1,1,0,0,0],<p>[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * <p>[0,1,0,0,1,1,0,0,1,0,1,0,0],<p>[0,1,0,0,1,1,0,0,1,1,1,0,0],<p>[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * <p>[0,0,0,0,0,0,0,1,1,1,0,0,0],<p>[0,0,0,0,0,0,0,1,1,0,0,0,0]]<p>
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 671 👎 0
 *
 * @author 王渔
 * @date 2022/1/25 23:23
 */
public class MaxAreaOfIsland {

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            //遍历每一个点
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        //深度优先算出岛屿大小  参考733.图像渲染
                        //并将岛屿变为海洋，记录最大值
                        max = Math.max(dfs(grid, i, j), max);
                    }
                }
            }
            return max;
        }

        int dfs(int[][] grid, int i, int j) {
            //递归超出边界
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return 0;
            }
            //将计数过的坐标变为海洋避免重复计数
            grid[i][j] = 0;
            //当前坐标计数1
            int count = 1;
            //当前坐标的上下左右进行递归计数
            count += dfs(grid, i + 1, j);
            count += dfs(grid, i - 1, j);
            count += dfs(grid, i, j + 1);
            count += dfs(grid, i, j - 1);
            //最后返回这个坐标相连的总岛屿数
            return count;
        }
    }
}
