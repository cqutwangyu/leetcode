package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列<p>
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * <p>
 * Related Topics 数组 回溯 👍 1763 👎 0
 *
 * @author 王渔
 * @date 2022/2/13 16:16
 */
public class Permutations {

    class Solution {
        /**
         * 利用递归回溯法
         * 递归压栈、循环遍历、跳过已访问、移除尾数、回溯
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtrack(answer, nums, new ArrayList<Integer>(), visited);
            return answer;
        }

        /**
         * 回溯法找出所有组合
         * [1]
         * [1, 2]
         * [1, 2, 3]
         * [1, 3]
         * [1, 3, 2]
         * [2]
         * [2, 1]
         * [2, 1, 3]
         * [2, 3]
         * [2, 3, 1]
         * [3]
         * [3, 1]
         * [3, 1, 2]
         * [3, 2]
         * [3, 2, 1]
         *
         * @param answer  组合结果集
         * @param nums    给定的数组
         * @param path    组合路径
         * @param visited 访问路径
         */
        private void backtrack(List<List<Integer>> answer, int[] nums, ArrayList<Integer> path, boolean[] visited) {
            // 找到一种组合
            if (path.size() == nums.length) {
                answer.add(new ArrayList<>(path));
                return;
            }

            // 遍历数组，跳过访问过的数
            for (int i = 0; i < nums.length; i++) {
                // 跳过已经访问过的数
                if (visited[i]) {
                    continue;
                }
                // 设置为访问过
                visited[i] = true;
                // 添加当前下标这个数到组合里
                path.add(nums[i]);
                // 递归
                backtrack(answer, nums, path, visited);
                // 移除最后一个数字，回溯
                path.remove(path.size() - 1);
                // 回溯设为没访问过
                visited[i] = false;
            }
        }
    }
}
