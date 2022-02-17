package com.company.leetcode;

/**
 * 74.搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10⁴ <= matrix[i][j], target <= 10⁴
 * <p>
 * Related Topics 数组 二分查找 矩阵 👍 576 👎 0
 *
 * @author 王渔
 * @date 2022/2/17 21:59
 */
public class Search2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //先找到所在的行
            int left = 0, right = matrix.length - 1;
            int rowMid = 0, colMid = 0, num;
            while (left <= right) {
                rowMid = left + (right - left) / 2;
                num = matrix[rowMid][colMid];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    left = rowMid + 1;
                } else if (num > target) {
                    right = rowMid - 1;
                }
            }

            //再找到所在的列
            rowMid = right < 0 ? 0 : right;
            left = 0;
            right = matrix[0].length - 1;
            while (left <= right) {
                colMid = left + (right - left) / 2;
                num = matrix[rowMid][colMid];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    left = colMid + 1;
                } else if (num > target) {
                    right = colMid - 1;
                }
            }
            return false;
        }
    }
}
