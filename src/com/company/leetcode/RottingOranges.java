package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994.腐烂的橘子
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 * <p>
 * Related Topics 广度优先搜索 数组 矩阵 👍 484 👎 0
 *
 * @author 王渔
 * @date 2022/1/29 20:22
 */
public class RottingOranges {

    class Solution {
        public int orangesRotting(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            //count记录新鲜橘子数，max记录最后一个橘子坏掉所用的时间
            int count = 0, max = 0;

            //遍历所有格子，初始化queue
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    //记录所有新鲜橘子的个数
                    if (grid[r][c] == 1) {
                        count++;
                    }
                    //找出所有坏的橘子坐标
                    if (grid[r][c] == 2) {
                        queue.add(new int[]{r, c});
                    }
                }
            }
            //没有好的橘子最接返回0
            if (count == 0) {
                return count;
            }

            //上下左右四个方向
            int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            //初始时queue中是所有值为2的坐标（坏掉的橘子坐标）
            //第二圈开始，是被感染导致坏掉的橘子坐标
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                //四个方向的操作
                for (int d = 0; d < 4; d++) {
                    int newR = r + dir[d][0];
                    int newC = c + dir[d][1];
                    if (newR >= 0 && newC >= 0 && newR < rows && newC < cols) {
                        //邻居是一个新鲜橘子
                        if (grid[newR][newC] == 1) {
                            //新鲜橘子减少一个
                            count--;
                            //新鲜橘子的值，为当前这个坏橘子的值+1
                            grid[newR][newC] = grid[r][c] + 1;
                            //记录这个新橘子变坏所用的时间（max-2就是结果）
                            max = grid[newR][newC];
                            queue.add(new int[]{newR, newC});
                        }
                    }
                }
            }
            //当count为0，新鲜橘子全部坏掉。否则存在永远不会坏的橘子，返回-1。
            return count == 0 ? max - 2 : -1;
        }
    }
}
