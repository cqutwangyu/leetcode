package com.company.leetcode;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * <p>
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = [
 * "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * <p>
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC",
 * "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
 * list1 的所有字符串都是 唯一 的。
 * list2 中的所有字符串都是 唯一 的。
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 212 👎 0
 *
 * @author 王渔
 * @date 2022/3/15 10:58
 */
public class MinimumIndexSumTwoLists {
    public static void main(String[] args) {
        String[] restaurant = new Solution().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "KFC", "Shogun"});
        System.out.println(Arrays.toString(restaurant));
    }

    static class Solution {
        public String[] findRestaurant1(String[] list1, String[] list2) {
            //map判重
            Map<String, Integer> map = new HashMap<>();
            //结果集
            List<String> answer = new LinkedList<>();
            //最小索引次数
            int min = Integer.MAX_VALUE;
            //初始化map
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            //找共同喜好
            for (int i = 0; i < list2.length; i++) {
                //找到
                if (map.containsKey(list2[i])) {
                    //计算索引次数
                    int indexValue = map.get(list2[i]) + i;
                    //求最小索引次数集合
                    if (indexValue < min) {
                        min = indexValue;
                        answer.clear();
                        answer.add(list2[i]);
                    } else if (indexValue == min) {
                        answer.add(list2[i]);
                    }
                }
            }
            return answer.toArray(new String[answer.size()]);
        }

        public String[] findRestaurant(String[] list1, String[] list2) {
            //len
            int n = list1.length, m = list2.length;
            //map判重
            Map<String, Integer> map = new HashMap<>();
            //put(餐厅,下标)
            for (int i = 0; i < n; i++) map.put(list1[i], i);
            //找结果集
            List<String> ans = new LinkedList<>();
            //数组长度限制索引和必定小于2000
            int min = 2000;
            for (int i = 0; i < m; i++) {
                String s = list2[i];
                //不重复直接跳过
                if (!map.containsKey(s)) continue;
                //判断索引和是否最小
                if (i + map.get(s) < min) {
                    ans.clear();
                    min = i + map.get(s);
                    ans.add(s);
                } else if (i + map.get(s) == min) {
                    ans.add(s);
                }
            }
            return ans.toArray(new String[ans.size()]);
        }

    }
}
