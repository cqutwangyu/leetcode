package com.company.utils;

import java.util.Arrays;

/**
 * todo desc
 *
 * @author 王渔
 * @date 2022/1/24 9:50
 */
public class Print {
    public static void print(int[]... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
