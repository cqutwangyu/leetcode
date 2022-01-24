package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            //字符串转字典数值
            char[] chars = s.toCharArray();
            //找到最小的
            int min = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                min = chars[i] < chars[min] ? i : min;
            }
            //当最小数是第一个数时
            if (min == 0) {
                //找最大值换到末尾去
                int max = 1;
                for (int i = chars.length - 1; i >= 0; i--) {
                    max = chars[i] >= chars[max] ? i : max;
                }
                char temp = chars[chars.length - 1];
                chars[chars.length - 1] = chars[max];
                chars[max] = temp;
            } else {
                //数值最小的排前面
                char temp = chars[0];
                chars[0] = chars[min];
                chars[min] = temp;
                //构成字符串
            }
            System.out.println(new String(chars));
        }
    }
}
