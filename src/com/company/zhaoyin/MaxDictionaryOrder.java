package com.company.zhaoyin;

import java.util.Arrays;

/**
 * 根据字典序找出字符串的最大子序
 */
public class MaxDictionaryOrder {

    public static void main(String[] args) {
        String s1 = "cmbchina";
        String s2 = "na";
        String s3 = "aabcbccacbbcbaaba";
        String s4 = "cccccbba";
        System.out.println(new MaxDictionaryOrder().maxDictionaryOrder(s1).equals(s2));
        System.out.println(new MaxDictionaryOrder().maxDictionaryOrder(s3).equals(s4));
    }

    public String maxDictionaryOrder(String s) {
        char[] chars = s.toCharArray();
        //记录每个字母出现的次数，只包含小写字母
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 97]++;
        }
        System.out.println(Arrays.toString(count));
        //找字母的起始下标
        int strStart = -1;
        StringBuilder sb = new StringBuilder();
        //从字典尾部开始找
        for (int i = count.length - 1; i >= 0; i--) {
            //字母不存在
            if (count[i] <= 0) continue;
            //当前需要找的字母
            char target = (char) (i + 97);
            //初始化起始
            if (strStart == -1) {
                strStart = s.indexOf(target);
            }
            //从起始下标遍历字符串
            for (int j = strStart; j < s.length(); j++) {
                //需要找的字母全部找到了
                if (count[i] == 0) {
                    break;
                }
                //按顺序找到了目标字母
                if (s.charAt(j) == target) {
                    sb.append(s.charAt(j));
                    //起点坐标为当前下标+1
                    strStart = j + 1;
                    //需要找的目标字母数-1
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
