package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
 * ' 表示一支 蜡烛 。
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
 * lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
 * 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
 * 串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * <p>
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
 * ]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 10⁵
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 10⁵
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 * <p>
 * Related Topics 数组 字符串 二分查找 前缀和 👍 86 👎 0
 *
 * @author 王渔
 * @date 2022/3/8 14:43
 */
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        int[] answer;
        answer = new Solution().platesBetweenCandles(
                "**|**|***|", new int[][]{{2, 5}, {5, 9}}
        );
        System.out.println(Arrays.toString(answer));
        answer = new Solution().platesBetweenCandles(
                "***|**|*****|**||**|*",
                new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}
        );
        System.out.println(Arrays.toString(answer));
        answer = new Solution().platesBetweenCandles(
                "*|*||||**|||||||*||*||*||**|*|*||*",
                new int[][]{{2, 33}, {2, 32}, {3, 31}, {0, 33}, {1, 24}, {3, 20}, {7, 11}, {5, 32}, {2, 31}, {5, 31}, {0, 31}, {3, 28}, {4, 33}, {6, 29}, {2, 30}, {2, 28}, {1, 30}, {1, 33}, {4, 32}, {5, 30}, {4, 23}, {0, 30}, {3, 10}, {5, 28}, {0, 28}, {4, 28}, {3, 33}, {0, 27}}
        );
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] platesBetweenCandles4(String s, int[][] qs) {
            //预处理
            char[] cs = s.toCharArray();
            int n = cs.length, m = qs.length;
            int[] l = new int[n], r = new int[n];
            int[] sum = new int[n + 1];
            //i从左往右，j从右往左，p和q每次记录最近的蜡烛坐标
            for (int i = 0, j = n - 1, p = -1, q = -1;
                 i < n;
                 i++, j--) {
                //找到新的蜡烛
                if (cs[i] == '|') p = i;
                if (cs[j] == '|') q = j;
                //当前下标是蜡烛，则最近的蜡烛就是当前下标，否则就是上一次找到的蜡烛下标
                l[i] = p;
                r[j] = q;
                //前缀和
                sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
            }
            //求解
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int left = qs[i][0], right = qs[i][1];
                //left到right之间往右第一个蜡烛的下标，right到left之间往左第一个蜡烛的下标
                int c = r[left], d = l[right];
                //通过前缀和求解
                if (c != -1 && c <= d) ans[i] = sum[d + 1] - sum[c];
            }
            return ans;
        }

        public int[] platesBetweenCandles(String s, int[][] qs) {
            //预处理
            char[] cs = s.toCharArray();
            int n = cs.length, m = qs.length;
            //答案集合，前缀和数组
            int[] ans = new int[m], sum = new int[n + 1];
            //所有蜡烛出现的位置，及其对应的盘子数
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (cs[i] == '|') list.add(i);
                //根据前缀和求出第一个蜡烛到当前下标的盘子数
                //下标错位cs[i]的盘子数是sum[i+1]
                sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
            }
            //没有蜡烛直接退出
            if (list.size() == 0) return ans;

            //找出所有答案
            for (int i = 0; i < m; i++) {
                //计算a到b之间的蜡烛中间盘子数
                int a = qs[i][0], b = qs[i][1];
                int c = -1, d = -1;
                // 找到 a 右边最近的蜡烛
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) >= a) r = mid;
                    else l = mid + 1;
                }
                if (list.get(r) >= a) c = list.get(r);
                else {
                    continue;
                }
                // 找到 b 左边最近的蜡烛
                l = 0;
                r = list.size() - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list.get(mid) <= b) l = mid;
                    else r = mid - 1;
                }
                if (list.get(r) <= b) d = list.get(r);
                else continue;
                //a到b的有效盘子数 = 0到d的有效盘子数 - 0到c的有效盘子数
                if (c <= d) ans[i] = sum[d + 1] - sum[c];
                //若c > d 说明有效盘子数为0
            }
            return ans;
        }

        public int[] platesBetweenCandles2(String s, int[][] queries) {
            int[] answer = new int[queries.length];
            char[] chars = s.toCharArray();
            List<Integer> cList = new ArrayList<>();
            //找出所有蜡烛的位置
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '|') {
                    cList.add(i);
                }
            }

            for (int index = 0; index < queries.length; index++) {
                int l = queries[index][0], l1 = -1;
                int r = queries[index][1], r1 = -2;
                System.out.println(s);
                System.out.println(l + " " + r);
                //找出l到r之间第一个蜡烛的位置
                int left = 0, right = cList.size();
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (cList.get(mid) == l) {
                        left = mid;
                        break;
                    } else if (cList.get(mid) < l) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                l1 = cList.get(left) < r ? cList.get(left) : l1;
                //找出l到r之间最后一个蜡烛的位置
                right = cList.size() - 1;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (cList.get(mid) == r) {
                        right = mid;
                        break;
                    } else if (cList.get(mid) > r) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (cList.get(right) <= r || (cList.get(--right) >= l && cList.get(right) <= r)) {
                    r1 = cList.get(right);
                }


                int cCount = 0;
                for (int i = l1; i <= r1; i++) {
                    if (chars[i] == '|') {
                        cCount++;
                    }
                }
                answer[index] = r1 - l1 - cCount + 1;
                System.out.println(l1 + " " + r1 + " = " + answer[index]);
                System.out.println();
            }
            return answer;
        }

        public int[] platesBetweenCandles1(String s, int[][] queries) {
            int[] answer = new int[queries.length];
            char[] chars = s.toCharArray();
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                int sum = 0;
                int pCount = 0, cCount = 0;
                for (int j = l; j <= r; j++) {
                    if (chars[j] == '|') {
                        cCount++;
                    } else if (cCount != 0) {
                        pCount++;
                    }
                    if (cCount != 0 && cCount % 2 == 0) {
                        sum += pCount;
                        cCount = 1;
                        pCount = 0;
                    }
                }
                answer[i] = sum;
            }
            return answer;
        }
    }
}
