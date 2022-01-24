package com.company.huawei;

import java.util.*;

/**
 * 给你一堆区间，请将拥有共同区间的区间合并后输出
 * 例如：
 * 0 3：0 1 2 3
 * 1 3：1 2 3
 * 3 5：3 4 5
 * 3 6：3 4 5 6
 * 输出：
 * 1 5：1 2 3 4 5
 * <p>
 * 例如：
 * 0 3：0 1 2 3
 * 1 4：1 2 3 4
 * 4 7：4 5 6 7
 * 5 8：5 6 7 8
 * 输出：
 * 1 3：1 2 3
 * 4 4：4
 * 5 7：5 6 7
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String[]> lists = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("ok")) {
                break;
            }
            String[] s1 = s.split(" ");
            lists.add(s1);
        }
        //判断区间是否有交集
        for (int i = 0; i < lists.size(); i++) {
            String[] strings = lists.get(i);
        }

        //合并交集区间

        //输出合并后的结果
    }
}
