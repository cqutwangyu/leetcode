package com.company.leetcode;

/**
 * 2125. 银行中的激光束数量
 * <p>
 * 银行内部的防盗安全装置已经激活。给你一个下标从 0 开始的二进制字符串数组 bank ，表示银行的平面图，这是一个大小为 m x n 的二维矩阵。
 * bank[i] 表示第 i 行的设备分布，由若干 '0' 和若干 '1' 组成。'0' 表示单元格是空的，而 '1' 表示单元格有一个安全设备。
 * 对任意两个安全设备而言，如果同时 满足下面两个条件，则二者之间存在 一个 激光束：
 * <p>
 * 两个设备位于两个 不同行 ：r1 和 r2 ，其中 r1 < r2 。
 * 满足 r1 < i < r2 的 所有 行 i ，都 没有安全设备 。
 * <p>
 * 激光束是独立的，也就是说，一个激光束既不会干扰另一个激光束，也不会与另一个激光束合并成一束。
 * 返回银行中激光束的总数量。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：bank = ["011001","000000","010100","001000"]
 * 输出：8
 * 解释：在下面每组设备对之间，存在一条激光束。总共是 8 条激光束：
 * * bank[0][1] -- bank[2][1]
 * * bank[0][1] -- bank[2][3]
 * * bank[0][2] -- bank[2][1]
 * * bank[0][2] -- bank[2][3]
 * * bank[0][5] -- bank[2][1]
 * * bank[0][5] -- bank[2][3]
 * * bank[2][1] -- bank[3][2]
 * * bank[2][3] -- bank[3][2]
 * 注意，第 0 行和第 3 行上的设备之间不存在激光束。
 * 这是因为第 2 行存在安全设备，这不满足第 2 个条件。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：bank = ["000","111","000"]
 * 输出：0
 * 解释：不存在两个位于不同行的设备
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == bank.length
 * n == bank[i].length
 * 1 <= m, n <= 500
 * bank[i][j] 为 '0' 或 '1'
 * <p>
 * Related Topics 数组 数学 字符串 矩阵 👍 6 👎 0
 *
 * @author 王渔
 * @date 2022/3/27 12:15
 */
public class NumberLaserBeamsInBank {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }

    static class Solution {
        public int numberOfBeams(String[] bank) {
            int count = 0, top = 0, cur = 0;
            for (int i = 0; i < bank.length; i++) {
                char[] chars = bank[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '1') {
                        cur++;
                    }
                }
                if (top != 0 && cur != 0) {
                    count += top * cur;
                    top = cur;
                    cur = 0;
                } else if (top == 0) {
                    top = cur;
                    cur = 0;
                }
            }
            return count;
        }
    }
}
