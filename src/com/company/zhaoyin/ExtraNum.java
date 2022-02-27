package com.company.zhaoyin;

import java.util.ArrayList;

/**
 * 提取数字
 */
public class ExtraNum {

    public static void main(String[] args) {
        String s = "c12m23b3n4t56";
        System.out.println(new ExtraNum().extraNum(s));
    }

    public ArrayList<Integer> extraNum(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = 0, len = s.length();
        while (l < len) {
            if (Character.isDigit(s.charAt(l))) {
                r = l;
                while (r < len && Character.isDigit(s.charAt(r))) {
                    r++;
                }
                String strInt = s.substring(l, r);
                list.add(Integer.valueOf(strInt));
                l = r;
            }
            l++;
        }
        return list;
    }
}
