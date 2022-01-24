package com.company.huawei;

import java.util.Scanner;

/**
 * 给你n个数，给你一个窗口大小，让你求出这个窗口在数组中能取得的最大和。
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            try {
                //数的个数
                int len = in.nextInt();
                //输入的n个数
                int[] ints = new int[len];
                for (int i = 0; i < len; i++) {
                    ints[i] = in.nextInt();
                }
                //窗口大小
                int m = in.nextInt();
                //窗口左右
                int q = 0, p = m - 1;
                //最大值
                int max = 0;
                while (p < len) {
                    int temp = 0;
                    for (int i = q; i <= p; i++) {
                        temp += ints[i];
                    }
                    max = max < temp ? temp : max;
                    q++;
                    p++;
                }
                //滑动窗口和最大值
                System.out.println(max);
            } catch (Exception e) {

            }
        }
    }
}
