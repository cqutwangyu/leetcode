package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77.组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * Related Topics 数组 回溯 👍 846 👎 0
 *
 * @author 王渔
 * @date 2022/1/31 14:19
 */
public class Combinations {

    public static class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            //根据题意1到n的数，从1开始
            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
//            for (int i = index; i <= n; i++) {
            // 剪枝（剩余的数组不成k个数的组合）
            for (int i = index; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
//                System.out.println("递归之前 => " + path);
                dfs(n, k, i + 1, path, res);
                path.removeLast();
//                System.out.println("递归之后 => " + path);
            }
        }
    }


}
