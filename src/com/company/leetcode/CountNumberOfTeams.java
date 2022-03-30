package com.company.leetcode;

/**
 * 1395. 统计作战单位数
 * <p>
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * <p>
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[
 * k] ，其中 0 <= i < j < k < n
 * <p>
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * <p>
 * 示例 3：
 * <p>
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 10^5
 * rating 中的元素都是唯一的
 * <p>
 * Related Topics 树状数组 数组 动态规划 👍 95 👎 0
 *
 * @author 王渔
 * @date 2022/3/30 21:06
 */
public class CountNumberOfTeams {
    class Solution {
        /**
         * 暴力解
         */
        public int numTeams(int[] rating) {
            int n = rating.length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    for (int k = j + 1; k < n; ++k) {
                        if ((rating[i] < rating[j] && rating[j] < rating[k])
                                || (rating[i] > rating[j] && rating[j] > rating[k])) {
                            ++ans;
                        }
                    }
                }
            }
            return ans;
        }

        /**
         * 树状数组
         */
        public int numTeams1(int[] rating) {
            //树状数组来做
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : rating) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            int n = rating.length;
            //将数组中的所有元素都减去(min - 1)用于排名，即min排名为第一
            for (int i = 0; i < rating.length; i++) {
                rating[i] = rating[i] - min + 1;
            }
            //创建两个树状数组分别用于降序作战单位和升序作战单位的C[i]
            int[] tree1 = new int[max - min + 2];
            int[] tree2 = new int[max - min + 2];
            //创建4个数组分别为左边小于当前元素的个数，左边大于当前元素的个数以及右边小于和大于当前数字的个数
            int[] lLess = new int[n];
            int[] lMore = new int[n];
            int[] rLess = new int[n];
            int[] rMore = new int[n];
            //先从前向后遍历数组，计算升序的作战单位的数量，即更新左边小于和大于当前数字的个数
            for (int i = 1; i < n - 1; i++) {
                int j = rating[i - 1];
                update(j, 1, tree1);
                lLess[i] = query(rating[i] - 1, tree1);
                lMore[i] = i - lLess[i];
            }
            //从后向前遍历数组，计算降序的作战单位的数量，即更新右边小于和大于当前数字的个数
            for (int i = n - 2; i >= 1; i--) {
                int j = rating[i + 1];
                update(j, 1, tree2);
                rLess[i] = query(rating[i] - 1, tree2);
                rMore[i] = n - 1 - i - rLess[i];
            }
            int res = 0;
            //计算作战单位的数量，枚举中间的士兵的评分
            for (int i = 1; i < n - 1; i++) {
                res += lLess[i] * rMore[i];
                res += lMore[i] * rLess[i];
            }
            return res;
        }

        //单点更新
        public void update(int i, int k, int[] array) {
            while (i < array.length) {
                array[i] += k;
                i += i & (-i);
            }
        }

        //查询操作，即求sum[i]
        public int query(int i, int[] array) {
            int res = 0;
            while (i > 0) {
                res += array[i];
                i -= i & (-i);
            }
            return res;
        }
    }
}
