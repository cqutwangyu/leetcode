package com.company.leetcode;

/**
 * 5259. 计算应缴税款总额
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，表示第 i 个税级的上限是 upperi ，征收的税率为 percenti 。税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upperi-1 < upperi）。
 * <p>
 * 税款计算方式如下：
 * <p>
 * 不超过 upper0 的收入按税率 percent0 缴纳
 * 接着 upper1 - upper0 的部分按税率 percent1 缴纳
 * 然后 upper2 - upper1 的部分按税率 percent2 缴纳
 * 以此类推
 * 给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10-5 的结果将被视作正确答案。
 *
 * @author 王渔
 * @date 2022/6/12 10:45
 */
public class CalculateAmountPaidInTaxes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }

    static class Solution {
        public double calculateTax(int[][] brackets, int income) {
            //第一级别
            double result = brackets[0][0] * brackets[0][1];
            for (int i = 1; i < brackets.length; i++) {
                if (income < brackets[i - 1][0]) {
                    break;
                }
                int v = Math.min(brackets[i][0], income) - brackets[i - 1][0];
                double ratal = v * brackets[i][1];
                result = result + ratal;
                System.out.println(result);
                if (i + 1 >= brackets.length || income <= brackets[i][0]) {
                    break;
                }
            }
            return result / 100;
        }
    }
}
